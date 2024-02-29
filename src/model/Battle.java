package model;

public class Battle {

    public static void fight(Player player, Agent agent) {
        System.out.println("Fuiste descubierto por un Agente, prepárate para el enfrentamiento!");
        
        boolean playerDefeated = false;
        boolean enemyDefeated = false;
        
        while (!playerDefeated && !enemyDefeated) {
            int playerDamage = player.getStrength();
            int enemyDamage = agent.getStrength();
            
            // Turno del jugador
            int enemyHP = Math.max(0, agent.getHealth() - playerDamage);
            agent.setHealth(enemyHP);
            System.out.println(player.getName() + " ataca al enemigo y causa " + playerDamage + " de daño.");
            System.out.println("El enemigo tiene " + enemyHP + " de salud.");

            // ver si se murió el enemigo
            if (enemyHP <= 0) {
                System.out.println("¡El enemigo ha sido derrotado!");
                enemyDefeated = true;
            } else {
                // Turno del enemigo
                int playerHP = Math.max(0, player.getHealth() - enemyDamage);
                player.setHealth(playerHP);
                System.out.println("El enemigo te ataca y causa " + enemyDamage + " de daño.");
                System.out.println("Tienes " + playerHP + " de salud.");

                // Ver si se murió el jugador
                if (playerHP <= 0) {
                    System.out.println("¡Has sido derrotado!");
                    playerDefeated = true;
                }
            }
        }
        
        System.out.println("La batalla ha terminado.");
    }
}
