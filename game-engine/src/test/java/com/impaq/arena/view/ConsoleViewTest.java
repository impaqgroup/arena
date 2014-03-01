/*
 * Copyright (C) 2014 Jaroslaw Herod <jaroslaw.herod@impaqgroup.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.impaq.arena.view;

import com.impaq.arena.event.GameStarted;
import com.impaq.arena.event.SpyWarriors;
import com.impaq.arena.event.SpyWizards;
import com.impaq.arena.event.Winner;
import com.impaq.arena.player.Player;
import java.io.PrintStream;
import java.io.PrintWriter;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author Jaroslaw Herod <jaroslaw.herod@impaqgroup.com>
 */
@RunWith(MockitoJUnitRunner.class)
public class ConsoleViewTest {

    @Mock
    private PrintStream out;

    @Mock
    private Player first;

    @Mock
    private Player second;

    @InjectMocks
    private ConsoleView view;

    private ArgumentCaptor<String> lines = ArgumentCaptor.forClass(String.class);

    @Test
    public void shouldDisplayStartMessageOnGameStarted() {
        //Given
        GameStarted event = new GameStarted(first, second);
        //When
        view.onGameStart(event);
        //Then
        assertLinePrinted("Game started");
    }

    @Test
    public void shouldDisplayTheWinnerWhenFirstPlayerIsWinner() {
        //Given
        Winner winner = new Winner(first);
        givenGameStarted();
        //When
        view.onWinner(winner);

        //Then
        assertLinePrinted("And The Winner is First player !!!!!");
    }

    @Test
    public void shouldDisplayTheWinnerWhenSecondPlayerIsWinner() {
        //Given
        Winner winner = new Winner(second);
        givenGameStarted();
        //When
        view.onWinner(winner);

        //Then
        assertLinePrinted("And The Winner is Second player !!!!!");
    }

    @Test
    public void shouldDisplaySpyWizardsActionExecutedByFirstPlayer() {
        //Given
        givenGameStarted();
        SpyWizards event = new SpyWizards(first);
        //When
        view.onSpyWizards(event);
        //Then
        assertLinePrinted("First Player is checking enemy wizards.");
    }

    private void givenGameStarted() {
        view.onGameStart(new GameStarted(first, second));
    }

    private void assertLinePrinted(String line) {
        verify(out, atLeastOnce()).println(lines.capture());
        lines.getAllValues().contains(line);
    }

}
