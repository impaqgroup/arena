package com.impaq.arena.server.login.user

import com.impaq.arena.server.login.player.Player
import com.impaq.arena.server.login.player.PlayerRepository
import com.impaq.arena.server.login.util.Copy
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Component

@Component
class UserService implements UserDetailsService {

    private final PlayerRepository repository
    private final List<String> admins

    @Autowired
    UserService(PlayerRepository repository, @Value('${admins}') List<String> admins) {
        this.repository = repository
        this.admins = admins
    }

    @Override
    User loadUserByUsername(String username) throws UsernameNotFoundException {
        Player player = repository.findOne(username)
        if (player == null) {
            throw new UsernameNotFoundException("Invalid credentials!")
        }
        if (admins.contains(username)) {
            return use(Copy, { player.copyTo(Admin) })
        } else {
            return use(Copy, { player.copyTo(User) })
        }
    }

}
