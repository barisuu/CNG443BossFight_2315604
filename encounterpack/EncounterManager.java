
//CNG 443 Assignment 1
//Barış Utku Ünsal 2315604


package encounterpack;

import java.util.Scanner;

/**
 * The type Encounter manager to hold all info for the encounter.
 */
public class EncounterManager {

    /**
     * The Scanner to take input.
     */
    Scanner scanner = new Scanner(System.in);
    /**
     * The Enemy created to immediately test.
     */
    EnemyEntity enemy=new EnemyEntity(3,100,10);
    /**
     * The Tank created to immediately test.
     */
    Tank tank=new Tank(100,10,"Tank",6);
    /**
     * The Damage Dealer created to immediately test.
     */
    DamageDealer damageDealer=new DamageDealer(100,10,"DamageDealer",7);
    /**
     * The Healer created to immediately test.
     */
    Healer healer=new Healer(100,10,"Healer",8);

    private void menu(){
        while(true){
            System.out.println("1) Register entities\n2) Start encounter\n3) Exit");
            int option=scanner.nextInt();
            if(option==1){
                System.out.println("Select entity to register: (1)Tank (2)Damage Dealer (3)Healer (4)Enemy");
                int regOption=scanner.nextInt();
                if(regOption==1){
                    this.registerTank();
                }
                else if(regOption==2){
                    this.registerDamageDealer();
                }
                else if(regOption==3){
                    this.registerHealer();
                }
                else if(regOption==4){
                    this.spawnEnemy();
                }
                else{
                    System.out.println("Wrong input.");
                }
            }
            else if(option==2){
                System.out.println("The encounter has started!\n\n");
                while(this.enemyIsAlive()==true && this.playersAreAlive()==true){
                    System.out.println("==========================");
                    System.out.println("Entities' HP\n");
                    System.out.println("Tank: " + this.tank.getHealthPoints() + "\nDamage Dealer: " + this.damageDealer.getHealthPoints() + "\nHealer: " + this.healer.getHealthPoints() + "\nEnemy: " + this.enemy.getHealthPoints());
                    System.out.println("==========================");
                    System.out.println("a)Player attack\nb)Player heal\nc)Enemy attack\nd)Enemy group-wide attack\ne)Stop the encounter");
                    char fightOption=scanner.next().charAt(0);        //Taking User input to attack

                    if(fightOption=='a'){
                        this.playerAttack();
                    }

                    else if(fightOption=='b'){
                        this.healPlayer();
                    }

                    else if(fightOption=='c'){
                        this.enemyAttack();
                    }

                    else if(fightOption=='d'){
                        this.groupWideAttack();
                    }
                    else if(fightOption=='e'){
                        break;
                    }
                }
            }
            else if(option==3){
                return;
            }
            else{
                System.out.println("Wrong input.");
            }
        }
    }

    //Asks for the values  and then creates a tank entity with given values.
    private void registerTank(){
        System.out.println("Enter HP, DMG and DEF of tank:");
        int HP=scanner.nextInt();
        int DMG=scanner.nextInt();
        int DEF=scanner.nextInt();
        tank=new Tank(HP,DMG,"Tank",DEF);
    }
    //Asks for the values  and then creates a damage dealer entity with given values.
    private void registerDamageDealer(){
        System.out.println("Enter HP, DMG and INTEL of damageDealer:");
        int HP=scanner.nextInt();
        int DMG=scanner.nextInt();
        int INTEL=scanner.nextInt();
        damageDealer=new DamageDealer(HP,DMG,"DamageDealer",INTEL);
    }
    //Asks for the values  and then creates a healer entity with given values.
    private void registerHealer(){
        System.out.println("Enter HP, DMG and MND of healer:");
        int HP=scanner.nextInt();
        int DMG=scanner.nextInt();
        int MND=scanner.nextInt();
        healer=new Healer(HP,DMG,"Healer",MND);
    }
    //Asks for the values  and then creates a enemy entity with given values.
    private void spawnEnemy(){
        System.out.println("Enter HP and DMG enemy:");
        int HP=scanner.nextInt();
        int DMG=scanner.nextInt();
        enemy=new EnemyEntity(7,HP,DMG);
    }

    private boolean enemyIsAlive(){
        if(enemy.getHealthPoints()<=0){
            return false;
        }
        else{
            return true;
        }
    }

    private boolean playersAreAlive(){
        if(tank.getHealthPoints()<=0 && damageDealer.getHealthPoints()<=0 && healer.getHealthPoints()<=0){
            return false;
        }
        else{
            return true;
        }
    }

    private void playerAttack(){
        System.out.println("Select the player that will attack: (T)ank (D)amage Dealer (H)ealer");
        char option = scanner.next().charAt(0); //Reads the option input as a string and then reads the first character of said string.
        if (option=='t'){
            enemy.takeDamage(tank.dealDamage());
        }
        else if (option=='d'){
            enemy.takeDamage(damageDealer.dealDamage());
        }
        else if (option=='h'){
            enemy.takeDamage(healer.dealDamage());
        }
        else{
            System.out.println("Wrong input.");
        }
    }

    private void enemyAttack(){
        System.out.println("Choose which player to attack: (t)ank,(d)amage dealer,(h)ealer");
        char attackOption=scanner.next().charAt(0);
        if(attackOption=='t'){
            this.tank.takeDamage(this.enemy.dealDamage());
        }
        else if(attackOption=='d'){
            this.damageDealer.takeDamage(this.enemy.dealDamage());
        }
        else if(attackOption=='h'){
            this.healer.takeDamage(this.enemy.dealDamage());
        }
        else{
            System.out.println("Wrong option");
        }
    }

    private void groupWideAttack(){
        //Adding hp check for players here so that it won't flood the interface with can't attack messages if a player is dead.
        if(this.tank.getHealthPoints()>0) {
            this.tank.takeDamage(this.enemy.dealDamage());
        }
        if(this.damageDealer.getHealthPoints()>0) {
            this.damageDealer.takeDamage(this.enemy.dealDamage());
        }
        if(this.healer.getHealthPoints()>0) {
            this.healer.takeDamage(this.enemy.dealDamage());
        }
    }

    private void healPlayer(){
        if(healer.getHealthPoints()<=0){
            System.out.println("Healer is dead. Cannot heal anyone.");
        }
        else{
            System.out.println("Select a player to heal: (T)ank (D)amage Dealer (H)ealer");
            char option = scanner.next().charAt(0); //Reads the option input as a string and then reads the first character of said string.
            if (option=='t'){
                if(tank.getHealthPoints()<=0){
                    System.out.println("Tank is dead. Cannot heal this player");
                    return;
                }
                else {
                    tank.setHealthPoints(tank.getHealthPoints()+healer.heal());
                }
            }
            else if (option=='d'){
                if(damageDealer.getHealthPoints()<=0){
                    System.out.println("Damage dealer is dead. Cannot heal this player");
                    return;
                }
                else {
                    damageDealer.setHealthPoints(damageDealer.getHealthPoints()+ healer.heal());
                }

            }
            else if (option=='h'){
                if(healer.getHealthPoints()<=0){
                    System.out.println("Healer is dead. Cannot heal this player");
                    return;
                }
                else {
                    healer.setHealthPoints(healer.getHealthPoints()+ healer.heal());
                }

            }
            else{
                System.out.println("Wrong input.");
            }
        }
    }


    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]){
        EncounterManager manager=new EncounterManager();
        Scanner scanner = new Scanner(System.in);

        manager.menu();



    }

}
