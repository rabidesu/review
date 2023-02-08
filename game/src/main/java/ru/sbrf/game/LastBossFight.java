package ru.sbrf.game;

// ТЗ: Реализовать битву с финальным боссом.
// Если в группе есть Орки, то босс их ваншотает (моментально убивает).
// Если в группе есть живой ангел, то он воскрешает всех убитых орков.
// Убийства и восрешения игроков должно происходить с записью в мониторинг
// Эльфы наносят двойной урон

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class LastBossFight {

    public final MonitoringService serviceOfMonitoring;

    public void start(ArrayList<Player> players, Boss boss) {
        try {
            checkForOrk(players);
        } catch (IncorrectPlayerTypeException e) {
            killOrcs(players);
        }

        if (players.stream().anyMatch(player -> player.getRace() == Race.ANGEL)) {
            for (Player player : players) {
                player.setPlayerState(PlayerState.ASLEEP);
            }
        }

        players.forEach(player -> {
            boss.setHP(boss.getHP() - (player.getRace() == Race.ELF ? player.getDamage() : player.getDamage() * 2));
        });

        //  Если здоровье босса опускается до нуля, то босс умирает
        if (boss.getHP() < 0) {
            killBoss(boss);
        }
    }


    // Проверка, если ли среди игроков орки
    private void checkForOrk(List<Player> players) {
        for (var player : players) {
            if (player.getRace().equals(Race.ORK)) {
                throw new IncorrectPlayerTypeException("There is Ork in group");
            }
        }
    }

    private void killOrcs(ArrayList<Player> players) {
        for (Player player : players) {
            if (player.getRace().equals(Race.ORK)) {
                player.setPlayerState(PlayerState.DEAD);
                serviceOfMonitoring.playerKilled(player);
            }
        }

    }

    public void killBoss(Boss boss) {
        boss.setBossState(PlayerState.DEAD);
    }
}
