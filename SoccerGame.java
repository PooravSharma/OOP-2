package soccergame;

/**
 *
 * @author 30045900
 */
public class SoccerGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Team team1 = new Team();
        Team team2 = new Team("hey");
        Team team3 = new Team();
        Team team4 = new Team("yo");
        Team[] teams = new Team[]{team1, team2, team3, team4};
        
        
        Scheduler scheduler = new Scheduler();
          scheduler.getTemp(teams);

       // System.out.println(team1.getTeamName());
       // System.out.println(team2.getTeamName());
       // System.out.println(team3.getTeamName());
       // System.out.println(team4.getTeamName());
       // System.out.println(team5.getTeamName());
        
        
      
    }

}
