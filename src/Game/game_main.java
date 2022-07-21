package Game;

import Game_Character.*;
import java.util.Scanner;
import java.util.Random;

public class game_main {
    public static void main(String[] args){
        // 게임 실행시 나오는 문구
        System.out.println("한여름 밤의 꿈 게임에 오신 것을 환영합니다. 당신은 아크왕국에 침공한 악마를 물리치기 위한 용사로서" +
                "아크왕국에 침공한 악마를 물리치기 위한 여정을 시작하게 됩니다. 긴말은 나중에하고 건투를 빕니다.");

        // 게임 캐릭터 만들기
        System.out.println("당신이 플레이할 직업을 선택하세요 : 1. 전사 2. 헌터 3. 마법사");
        Scanner scanner = new Scanner(System.in);
        int hero_choice = scanner.nextInt();

        Hero hero = new Hero("이상준", 5000, 100, 1000, 0,
                3000, 1000, "전사", "한손검", "갑옷",
                1500, 0, 1500, 1000,
                3000, 0, 4000, 2000)
        if(hero_choice == 2){

        }
        Hero hero2 = new Hero("이상준", 5000, 100, 1500, 0,
                    2000, 1000, "헌터", "활", "천",
                    2000, 0, 1000, 1000,
                    3500, 0, 3000, 2000);
        Hero hero3 = new Hero("이상준", 4000, 150, 0, 1500,
                    1000, 2000, "마법사", "지팡이", "로브",
                    0, 2000, 1000, 2000,
                    0, 3500, 2000, 4000);

        // 서브캐릭터
        Sub_hero zero = new Sub_hero("제로", 4500, 100, 1500, 0,
                2000, 1000, "기사단장", "한손검 방패", "갑옷", 2500,
                0, 1500, 1500, 4000, 0,
                3500, 2500);

        Sub_hero mari = new Sub_hero("마리", 4000, 150, 0, 2000,
                1000, 2000, "마법단장", "장지팡이", "로브", 0,
                2000, 1000, 1500, 0, 4000,
                2000, 3500);

        Sub_hero grandiel = new Sub_hero("그랑디엘", 4000, 120, 0, 1500,
                1500, 1500, "신성단장", "바이블", "로브", 0,
                1500, 1000, 1500, 0, 3000,
                2500, 3000);

        // 적캐릭터
        Enemy Durahhan = new Enemy("듀라한", 20000, 100, 1000, 0,
                2000, 0);

        Enemy Balzac = new Enemy("발자크", 25000, 100, 0, 1000,
                0, 2000);

        Enemy Heitaros = new Enemy("헤이타로스", 30000, 100, 1000, 1000,
                2000, 2000);

        //--------------------------------------메인-------------------------------------

        System.out.println("우리가 무찔러야하는 적이 듀라한, 발자크, 헤이타로스가 있어. 지금 우리의 실력으로는 듀라한이 적합할꺼 같군" +
                "누구를 잡으러 갈까? : 1. 정비한다 2. 듀라한 3. 발자크 4. 헤이타로스");
        int yes = scanner.nextInt();
        while(yes == 1){
            int number;
            System.out.println("1. 이상준 2. 제로 3. 마리 4. 그랑디엘");
            int choose = scanner.nextInt();
            switch(choose){
                case 1:
                    System.out.println("1. 스텟보기 2. 그만두기");
                    number = scanner.nextInt();
                    if(number == 1){
                        hero.Status();
                        break;
                    }
                    else{
                        break;
                    }
                case 2:
                    System.out.println("1. 스텟보기 2. 그만두기");
                    number = scanner.nextInt();
                    if(number == 1){
                        zero.Status();
                        break;
                    }
                    else{
                        break;
                    }
                case 3:
                    System.out.println("1. 스텟보기 2. 그만두기");
                    number = scanner.nextInt();
                    if(number == 1){
                        mari.Status();
                        break;
                    }
                    else{
                        break;
                    }
                case 4:
                    System.out.println("1. 스텟보기 2. 그만두기");
                    number = scanner.nextInt();
                    if(number == 1){
                        grandiel.Status();
                        break;
                    }
                    else{
                        break;
                    }
            }
            System.out.println("계속해서 정비하겠습니까? 1. 네 아직 부족한것 같습니다. 2. 아니오 이제 싸우러 가겠습니다.");
            yes = scanner.nextInt();
            if(yes == 1){
                continue;
            }
            else{
                break;
            }
        }
        if(yes == 2){ // 2번을 누르면 듀라한과의 전투가 벌어짐
            System.out.println("주인공 : 여기가 듀라한의 근거지인가? 진짜 으스스하게 생겼군");
            System.out.println("제로 : 조심하면서 가세요 듀라한이 갑자기 습격할 수 있습니다.");
            System.out.println("마리 : 그건 걱정 안해도 될꺼 같은데? 앞을봐 누가 있는지");
            System.out.println("그랑디엘 : 듀라한이군 모두 전투 준비!");
            System.out.println("듀라한 : 너희가 나를 잡으러 온 용사인지 뭐시기인가? 겁도없이 찾아왔군 모두 여기서 죽여주마");

            loop:
            while(true){
                System.out.println("지금부터 전투가 시작됩니다.");

                int hero_turn = 1; // 아군의 공격 순서 1이면 주인공, 2이면 제로, 3이면 마리, 4이면 그랑디엘의 순서이다.
                int enemy_turn = 1; // 적의 특수 스킬을 사용하기 위한 카운트 5,10,15,20이 될때마다 특수스킬을 사용
                int zero_count = 1; // 제로의 특수스킬을 카운트 하기 위함 전투마다 1번씩밖에 사용 못함
                int mari_count = 1; // 마리의 특수스킬을 카운트 하기 위함 전투마다 1번씩맊에 사용 못함
                int grandiel_count = 1; // 그랑디엘의 특수스킬을 카운트 하기 위함 전투마다 1번씩밖에 사용 못함

                loop1:
                while(hero.Hp > 0){
                    if(enemy_turn % 5 == 0) {
                        Durahhan.demonization(hero, zero, mari, grandiel);
                        if (hero_turn == 1) {
                            hero_turn = 2;
                            if (zero.Hp > 0) {
                                continue;
                            }
                        } else if (hero_turn == 2) {
                            hero_turn = 3;
                            if (mari.Hp > 0) {
                                continue;
                            }
                        } else if (hero_turn == 3) {
                            hero_turn = 4;
                            if (grandiel.Hp > 0) {
                                continue;
                            }
                        } else {
                            hero_turn = 1;
                            if (hero.Hp > 0) {
                                continue;
                            }
                        }
                    }
                    else{
                        Random random = new Random();
                        int choose_behavior = random.nextInt(2);
                        int choose_person = random.nextInt(4);
                        if(choose_behavior == 0){ // Durahhan의 기본공격
                            switch(choose_person){
                                case 0:
                                    Durahhan.attack(hero);
                                    enemy_turn++;
                                    break;
                                case 1:
                                    if(zero.Hp > 0){
                                        Durahhan.attack(zero);
                                        enemy_turn++;
                                        break;
                                    }
                                    else{
                                        System.out.println("Durahhan이 제로를 공격하려 했지만 제로는 이미 죽었습니다.");
                                        enemy_turn++;
                                        break;
                                    }
                                case 2:
                                    if(mari.Hp > 0){
                                        Durahhan.attack(mari);
                                        enemy_turn++;
                                        break;
                                    }
                                    else{
                                        System.out.println("Durahhan이 마리를 공격하려 했지만 마리는 이미 죽었습니다.");
                                        enemy_turn++;
                                        break;
                                    }
                                case 3:
                                    if(grandiel.Hp > 0){
                                        Durahhan.attack(grandiel);
                                        enemy_turn++;
                                        break;
                                    }
                                    else{
                                        System.out.println("Durahhan이 그랑디엘을 공격하려 했지만 그랑디엘은 이미 죽었습니다.");
                                        enemy_turn++;
                                        break;
                                    }
                            }
                            if(hero_turn == 2){
                                if(zero.Hp > 0){
                                    continue;
                                }
                                else {
                                    hero_turn++;
                                    if(mari.Hp > 0){
                                        continue;
                                    }
                                    else{
                                        hero_turn++;
                                        if(grandiel.Hp > 0){
                                            continue;
                                        }
                                        else{
                                            hero_turn++;
                                        }
                                    }
                                }
                            }
                            else if(hero_turn == 3){
                                if(mari.Hp > 0){
                                    continue;
                                }
                                else{
                                    hero_turn++;
                                    if(grandiel.Hp > 0){
                                        continue;
                                    }
                                    else{
                                        hero_turn = 1;
                                    }
                                }
                            }
                            else if(hero_turn == 4){
                                if(grandiel.Hp > 0){
                                    continue;
                                }
                                else{
                                    hero_turn = 1;
                                }
                            }
                        }

                        if(choose_behavior == 1){ // Durahhan의 스킬사용
                            switch(choose_person){
                                case 0:
                                    Durahhan.skill(hero);
                                    enemy_turn++;
                                    break;
                                case 1:
                                    if(zero.Hp > 0){
                                        Durahhan.skill(zero);
                                        enemy_turn++;
                                        break;
                                    }
                                    else{
                                        System.out.println("Durahhan이 제로를 공격하려 했지만 제로는 이미 죽었습니다.");
                                        enemy_turn++;
                                        break;
                                    }
                                case 2:
                                    if(mari.Hp > 0){
                                        Durahhan.skill(mari);
                                        enemy_turn++;
                                        break;
                                    }
                                    else{
                                        System.out.println("Durahhan이 마리를 공격하려 했지만 마리는 이미 죽었습니다.");
                                        enemy_turn++;
                                        break;
                                    }
                                case 3:
                                    if(grandiel.Hp > 0){
                                        Durahhan.skill(grandiel);
                                        enemy_turn++;
                                        break;
                                    }
                                    else{
                                        System.out.println("Durahhan이 그랑디엘을 공격하려 했지만 그랑디엘은 이미 죽었습니다.");
                                        enemy_turn++;
                                        break;
                                    }
                            }
                            if(hero_turn == 2){
                                if(zero.Hp > 0){
                                    continue;
                                }
                                else {
                                    hero_turn++;
                                    if(mari.Hp > 0){
                                        continue;
                                    }
                                    else{
                                        hero_turn++;
                                        if(grandiel.Hp > 0){
                                            continue;
                                        }
                                        else{
                                            hero_turn++;
                                        }
                                    }
                                }
                            }
                            else if(hero_turn == 3){
                                if(mari.Hp > 0){
                                    continue;
                                }
                                else{
                                    hero_turn++;
                                    if(grandiel.Hp > 0){
                                        continue;
                                    }
                                    else{
                                        hero_turn = 1;
                                    }
                                }
                            }
                            else if(hero_turn == 4){
                                if(grandiel.Hp > 0){
                                    continue;
                                }
                                else{
                                    hero_turn = 1;
                                }
                            }
                        }
                    }

                    loop2:
                    while(hero_turn == 1 && Durahhan.Hp > 0){ // 주인공의 공격하는 순서
                        System.out.println("1. 공격한다. 2. 스킬을쓴다.");
                        int attack_or_skill = scanner.nextInt();
                        if(attack_or_skill == 1) { // 주인공의 기본 공격
                            hero.attack(Durahhan);
                            if(Durahhan.Hp <= 0){ // 주인공의 공격으로 적의 체력이 0이되면 전투 종료
                                System.out.println("축하합니다. 적을 Durahhan을 물리쳤습니다.!");
                                break loop;
                            }
                            else{ // 그렇지 않으면 hero_turn은 2가되고 적의 턴으로 넘어감
                                hero_turn = 2;
                                System.out.println("Durahhan의 턴입니다.");
                                continue loop1;
                            }
                        }
                        if(attack_or_skill ==2){ // 주인공의 스킬사용
                            if(hero.Mp >= 30) { // 주인공의 Mp가 30보다 클 경우 스킬사용이 가능
                                hero.skill(Durahhan);
                                if (Durahhan.Hp <= 0) { // 주인공의 스킬사용으로 적의 체력이 0이되면 전투 종료
                                    System.out.println("축하합니다. 적을 Durahhan을 물리쳤습니다.!");
                                    break loop;
                                }
                                else { // 그렇지 않으면 hero_turn은 2가되고 적의 턴으로 넘어감
                                    hero_turn = 2;
                                    System.out.println("Durahhan의 턴입니다.");
                                    continue loop1;
                                }
                            }
                            else{ // 주인공의 Mp가 부족하여 스킬사용이 불가능
                                System.out.println("주인공의 Mp가 부족하여 스킬을 사용할 수 없습니다.");
                                continue loop2;
                            }
                        }
                    }

                    loop3:
                    while(hero_turn == 2 && Durahhan.Hp >0){ // 제로의 공격순서
                        System.out.println("1. 공격한다. 2. 스킬을쓴다. 3. 특수스킬을 쓴다.");
                        int attack_or_skill1 = scanner.nextInt();
                        if(attack_or_skill1 == 1) { // 제로의 기본공격
                            zero.attack(Durahhan);
                            if(Durahhan.Hp <= 0){ // 제로의 공격으로 적의 체력이 0이되면 전투종료
                                System.out.println("축하합니다. 적을 Durahhan을 물리쳤습니다.!");
                                break loop;
                            }
                            else{ // 그렇지 않으면 hero_turn은 3이되고 적의 턴으로 넘어감
                                hero_turn = 3;
                                System.out.println("Durahhan의 턴입니다.");
                                continue loop1;
                            }
                        }
                        if(attack_or_skill1 ==2) { // 제로의 스킬사용
                            if (zero.Mp >= 30) { // 제로의 Mp가 30보다 클 경우에 스킬사용이 가능
                                System.out.println("스킬을 사용할 대상을 고르시오. 1. 이상준 2. 제로 3. 마리 4. 그랑디엘"); // 제로의 스킬은 아군 중 한명의 물리방어력, 마법방어력을 올려주는 것이므로 한명을 선택해야함
                                int choose_one = scanner.nextInt();
                                switch (choose_one) {
                                    case 1:
                                        zero.skill(hero);
                                        hero_turn = 2;
                                        break;
                                    case 2:
                                        zero.skill(zero);
                                        hero_turn = 2;
                                        break;
                                    case 3:
                                        zero.skill(mari);
                                        hero_turn = 2;
                                        break;
                                    case 4:
                                        zero.skill(grandiel);
                                        hero_turn = 2;
                                        break;
                                }
                                System.out.println("Durahhan의 턴입니다.");
                                continue loop1;
                            }
                            else { // 제로의 Mp가 부족하여 스킬사용이 불가능
                                    System.out.println("제로의 Mp가 부족하여 스킬을 사용할 수 없습니다.");
                                    continue loop3;
                            }
                        }
                        if(attack_or_skill1 == 3 && zero_count == 1){ // 제로의 특수스킬 사용
                                zero.Special_Skill(hero, zero, mari, grandiel, Durahhan);
                                zero_count = 0;
                                hero_turn = 3;
                                System.out.println("Durahhan의 턴입니다.");
                                continue loop1;
                        }
                        else{
                            System.out.println("특수스킬의 사용횟수를 초과하였습니다.");
                            continue loop3;
                        }
                    }

                    loop4:
                    while(hero_turn == 3 && Durahhan.Hp >0){ // 마리의 공격순서
                        System.out.println("1. 공격한다. 2. 스킬을쓴다. 3. 특수스킬을 쓴다.");
                        int attack_or_skill2 = scanner.nextInt();
                        if(attack_or_skill2 == 1) { // 마리의 기본공격
                            mari.attack(Durahhan);
                            if(Durahhan.Hp <= 0){ // 마리의 공격으로 적의 체력이 0이되면 전투종료
                                System.out.println("축하합니다. 적을 Durahhan을 물리쳤습니다.!");
                                break loop;
                            }
                            else{ // 그렇지 않으면 hero_turn은 4이되고 적의 턴으로 넘어감
                                hero_turn = 4;
                                System.out.println("Durahhan의 턴입니다.");
                                continue loop1;
                            }
                        }

                        if(attack_or_skill2 ==2){ // 마리의 스킬사용
                            if(mari.Mp >= 30) { // 마리의 Mp가 30보다 클 경우에 스킬사용이 가능
                                mari.skill(Durahhan);
                                if(Durahhan.Hp <= 0){ // 마리의 스킬로 Durahhan의 체력이 0보다 작아지면 전투 종료
                                    System.out.println("축하합니다. 적을 Durahhan을 물리쳤습니다.!");
                                    break loop;
                                }
                                else{
                                    hero_turn = 4;
                                    System.out.println("Durahhan의 턴입니다.");
                                    continue loop1;
                                }
                            }
                        }
                        else{ // 마리의 Mp가 부족하여 스킬사용이 불가능
                            System.out.println("마리의 Mp가 부족하여 스킬을 사용할 수 없습니다.");
                            continue loop4;
                        }

                        if(attack_or_skill2 == 3 && mari_count == 1){ // 제로의 특수스킬 사용
                            mari.Special_Skill(hero, zero, mari, grandiel, Durahhan);
                            mari_count = 0;
                            if(Durahhan.Hp <= 0){
                                System.out.println("축하합니다. 적을 Durahhan을 물리쳤습니다.!");
                                break loop;
                            }
                            else{
                                hero_turn = 4;
                                System.out.println("Durahhan의 턴입니다.");
                                continue loop1;
                            }
                        }
                        else{
                            System.out.println("특수스킬의 사용횟수를 초과하였습니다.");
                            continue loop4;
                        }
                    }

                    loop5:
                    while(hero_turn == 4 && Durahhan.Hp >0){ // 그랑디엘의 공격순서
                        System.out.println("1. 공격한다. 2. 스킬을쓴다. 3. 특수스킬을 쓴다.");
                        int attack_or_skill3 = scanner.nextInt();
                        if(attack_or_skill3 == 1) { // 마리의 기본공격
                            grandiel.attack(Durahhan);
                            if(Durahhan.Hp <= 0){ // 그랑디엘의 공격으로 적의 체력이 0이되면 전투종료
                                System.out.println("축하합니다. 적을 Durahhan을 물리쳤습니다.!");
                                break loop;
                            }
                            else{ // 그렇지 않으면 hero_turn은 1이되고 적의 턴으로 넘어감
                                hero_turn = 1;
                                System.out.println("Durahhan의 턴입니다.");
                                continue loop1;
                            }
                        }
                        if(attack_or_skill3 == 2){ // 그랑디엘의 스킬사용
                            if(grandiel.Mp >= 30) { // 그랑디엘의 Mp가 30보다 클 경우에 스킬사용이 가능
                                System.out.println("스킬을 사용할 대상을 고르시오. 1. 이상준 2. 제로 3. 마리 4. 그랑디엘"); // 그랑디엘의 스킬은 아군 중 한명한테 힐을 해주는 것이기 때문에 한명을 선택
                                int choose_one = scanner.nextInt();
                                switch(choose_one){
                                    case 1:
                                        grandiel.skill(hero);
                                        hero_turn = 1;
                                        break;
                                    case 2:
                                        grandiel.skill(zero);
                                        hero_turn = 1;
                                        break;
                                    case 3:
                                        grandiel.skill(mari);
                                        hero_turn = 1;
                                        break;
                                    case 4:
                                        grandiel.skill(grandiel);
                                        hero_turn = 1;
                                        break;
                                    }
                                System.out.println("Durahhan의 턴입니다.");
                                continue loop1;
                            }
                        }
                        else{ // 그랑디엘의 Mp가 부족하여 스킬사용이 불가능
                            System.out.println("그랑디엘의 Mp가 부족하여 스킬을 사용할 수 없습니다.");
                            continue loop5;
                        }

                        if(attack_or_skill3 == 3 && grandiel_count == 1){ // 그랑디엘의 특수스킬 사용
                            grandiel.Special_Skill(hero, zero, mari, grandiel, Durahhan);
                            grandiel_count = 0;
                            System.out.println("Durahhan의 턴입니다.");
                            continue loop1;
                        }
                        else{
                            System.out.println("특수스킬의 사용횟수를 초과하였습니다.");
                            continue loop5;
                        }
                    }

                }
            }
        }
        System.out.println("주인공 : 듀라한을 물리쳤어. 이제 성으로 돌아가서 조금 쉬자.");
        System.out.println("제로 : 그래 힘든 전투였어. 침대가 그리운걸");
        System.out.println("마리 : 마법을 많이 써서 그런지 머리가 다 아파. 빨리가서 쉬고싶다.");
        System.out.println("그랑디엘 : 모두 전투를 하느라 고생많으셨어요 돌아가서 푹 쉬어요");
        System.out.println("---------------------------휴식 후 ------------------------");
        System.out.println("이제 충분히 쉰거 같아. 다음 적을 잡으러 갈까?");
        System.out.println("1. 정비한다 2. 듀라한 3. 발자크 4. 헤이타로스");
        yes = scanner.nextInt();
        while(yes == 1){
            int number;
            System.out.println("1. 이상준 2. 제로 3. 마리 4. 그랑디엘");
            int choose = scanner.nextInt();
            switch(choose){
                case 1:
                    System.out.println("1. 스텟보기 2. 그만두기");
                    number = scanner.nextInt();
                    if(number == 1){
                        hero.Status();
                        break;
                    }
                    else{
                        break;
                    }
                case 2:
                    System.out.println("1. 스텟보기 2. 그만두기");
                    number = scanner.nextInt();
                    if(number == 1){
                        zero.Status();
                        break;
                    }
                    else{
                        break;
                    }
                case 3:
                    System.out.println("1. 스텟보기 2. 그만두기");
                    number = scanner.nextInt();
                    if(number == 1){
                        mari.Status();
                        break;
                    }
                    else{
                        break;
                    }
                case 4:
                    System.out.println("1. 스텟보기 2. 그만두기");
                    number = scanner.nextInt();
                    if(number == 1){
                        grandiel.Status();
                        break;
                    }
                    else{
                        break;
                    }
            }
            System.out.println("계속해서 정비하겠습니까? 1. 네 아직 부족한것 같습니다. 2. 아니오 이제 싸우러 가겠습니다.");
            yes = scanner.nextInt();
            if(yes == 1){
                continue;
            }
            else{
                break;
            }
        }
        if(yes == 3){ // 3번을 누르면 발자크와의 전투가 벌어짐
            loop:
            while(true){
                System.out.println("지금부터 전투가 시작됩니다.");

                int hero_turn = 1; // 아군의 공격 순서 1이면 주인공, 2이면 제로, 3이면 마리, 4이면 그랑디엘의 순서이다.
                int enemy_turn = 1; // 적의 특수 스킬을 사용하기 위한 카운트 5,10,15,20이 될때마다 특수스킬을 사용
                int zero_count = 1; // 제로의 특수스킬을 카운트 하기 위함 전투마다 1번씩밖에 사용 못함
                int mari_count = 1; // 마리의 특수스킬을 카운트 하기 위함 전투마다 1번씩맊에 사용 못함
                int grandiel_count = 1; // 그랑디엘의 특수스킬을 카운트 하기 위함 전투마다 1번씩밖에 사용 못함

                loop1:
                while(hero.Hp > 0){
                    if(enemy_turn % 5 == 0) {
                        Balzac.demonization(hero, zero, mari, grandiel);
                        if (hero_turn == 1) {
                            hero_turn = 2;
                            if (zero.Hp > 0) {
                                continue;
                            }
                        } else if (hero_turn == 2) {
                            hero_turn = 3;
                            if (mari.Hp > 0) {
                                continue;
                            }
                        } else if (hero_turn == 3) {
                            hero_turn = 4;
                            if (grandiel.Hp > 0) {
                                continue;
                            }
                        } else {
                            hero_turn = 1;
                            if (hero.Hp > 0) {
                                continue;
                            }
                        }
                    }
                    else{
                        Random random = new Random();
                        int choose_behavior = random.nextInt(2);
                        int choose_person = random.nextInt(4);
                        if(choose_behavior == 0){ // Balzac의 기본공격
                            switch(choose_person){
                                case 0:
                                    Balzac.attack(hero);
                                    enemy_turn++;
                                    break;
                                case 1:
                                    if(zero.Hp > 0){
                                        Balzac.attack(zero);
                                        enemy_turn++;
                                        break;
                                    }
                                    else{
                                        System.out.println("Balzac이 제로를 공격하려 했지만 제로는 이미 죽었습니다.");
                                        enemy_turn++;
                                        break;
                                    }
                                case 2:
                                    if(mari.Hp > 0){
                                        Balzac.attack(mari);
                                        enemy_turn++;
                                        break;
                                    }
                                    else{
                                        System.out.println("Balzac이 마리를 공격하려 했지만 마리는 이미 죽었습니다.");
                                        enemy_turn++;
                                        break;
                                    }
                                case 3:
                                    if(grandiel.Hp > 0){
                                        Balzac.attack(grandiel);
                                        enemy_turn++;
                                        break;
                                    }
                                    else{
                                        System.out.println("Balzac이 그랑디엘을 공격하려 했지만 그랑디엘은 이미 죽었습니다.");
                                        enemy_turn++;
                                        break;
                                    }
                            }
                            if(hero_turn == 2){
                                if(zero.Hp > 0){
                                    continue;
                                }
                                else {
                                    hero_turn++;
                                    if(mari.Hp > 0){
                                        continue;
                                    }
                                    else{
                                        hero_turn++;
                                        if(grandiel.Hp > 0){
                                            continue;
                                        }
                                        else{
                                            hero_turn++;
                                        }
                                    }
                                }
                            }
                            else if(hero_turn == 3){
                                if(mari.Hp > 0){
                                    continue;
                                }
                                else{
                                    hero_turn++;
                                    if(grandiel.Hp > 0){
                                        continue;
                                    }
                                    else{
                                        hero_turn = 1;
                                    }
                                }
                            }
                            else if(hero_turn == 4){
                                if(grandiel.Hp > 0){
                                    continue;
                                }
                                else{
                                    hero_turn = 1;
                                }
                            }
                        }

                        if(choose_behavior == 1){ // Balzac의 스킬사용
                            switch(choose_person){
                                case 0:
                                    Balzac.skill(hero);
                                    enemy_turn++;
                                    break;
                                case 1:
                                    if(zero.Hp > 0){
                                        Balzac.skill(zero);
                                        enemy_turn++;
                                        break;
                                    }
                                    else{
                                        System.out.println("Balzac이 제로를 공격하려 했지만 제로는 이미 죽었습니다.");
                                        enemy_turn++;
                                        break;
                                    }
                                case 2:
                                    if(mari.Hp > 0){
                                        Balzac.skill(mari);
                                        enemy_turn++;
                                        break;
                                    }
                                    else{
                                        System.out.println("Balzac이 마리를 공격하려 했지만 마리는 이미 죽었습니다.");
                                        enemy_turn++;
                                        break;
                                    }
                                case 3:
                                    if(grandiel.Hp > 0){
                                        Balzac.skill(grandiel);
                                        enemy_turn++;
                                        break;
                                    }
                                    else{
                                        System.out.println("Balzac이 그랑디엘을 공격하려 했지만 그랑디엘은 이미 죽었습니다.");
                                        enemy_turn++;
                                        break;
                                    }
                            }
                            if(hero_turn == 2){
                                if(zero.Hp > 0){
                                    continue;
                                }
                                else {
                                    hero_turn++;
                                    if(mari.Hp > 0){
                                        continue;
                                    }
                                    else{
                                        hero_turn++;
                                        if(grandiel.Hp > 0){
                                            continue;
                                        }
                                        else{
                                            hero_turn++;
                                        }
                                    }
                                }
                            }
                            else if(hero_turn == 3){
                                if(mari.Hp > 0){
                                    continue;
                                }
                                else{
                                    hero_turn++;
                                    if(grandiel.Hp > 0){
                                        continue;
                                    }
                                    else{
                                        hero_turn = 1;
                                    }
                                }
                            }
                            else if(hero_turn == 4){
                                if(grandiel.Hp > 0){
                                    continue;
                                }
                                else{
                                    hero_turn = 1;
                                }
                            }
                        }
                    }

                    loop2:
                    while(hero_turn == 1 && Balzac.Hp > 0){ // 주인공의 공격하는 순서
                        System.out.println("1. 공격한다. 2. 스킬을쓴다.");
                        int attack_or_skill = scanner.nextInt();
                        if(attack_or_skill == 1) { // 주인공의 기본 공격
                            hero.attack(Balzac);
                            if(Balzac.Hp <= 0){ // 주인공의 공격으로 적의 체력이 0이되면 전투 종료
                                System.out.println("축하합니다. 적을 Balzac을 물리쳤습니다.!");
                                break loop;
                            }
                            else{ // 그렇지 않으면 hero_turn은 2가되고 적의 턴으로 넘어감
                                hero_turn = 2;
                                System.out.println("Balzac의 턴입니다.");
                                continue loop1;
                            }
                        }
                        if(attack_or_skill ==2){ // 주인공의 스킬사용
                            if(hero.Mp >= 30) { // 주인공의 Mp가 30보다 클 경우 스킬사용이 가능
                                hero.skill(Balzac);
                                if (Balzac.Hp <= 0) { // 주인공의 스킬사용으로 적의 체력이 0이되면 전투 종료
                                    System.out.println("축하합니다. 적을 Balzac을 물리쳤습니다.!");
                                    break loop;
                                }
                                else { // 그렇지 않으면 hero_turn은 2가되고 적의 턴으로 넘어감
                                    hero_turn = 2;
                                    System.out.println("Balzac의 턴입니다.");
                                    continue loop1;
                                }
                            }
                            else{ // 주인공의 Mp가 부족하여 스킬사용이 불가능
                                System.out.println("주인공의 Mp가 부족하여 스킬을 사용할 수 없습니다.");
                                continue loop2;
                            }
                        }
                    }

                    loop3:
                    while(hero_turn == 2 && Balzac.Hp >0){ // 제로의 공격순서
                        System.out.println("1. 공격한다. 2. 스킬을쓴다. 3. 특수스킬을 쓴다.");
                        int attack_or_skill1 = scanner.nextInt();
                        if(attack_or_skill1 == 1) { // 제로의 기본공격
                            zero.attack(Durahhan);
                            if(Balzac.Hp <= 0){ // 제로의 공격으로 적의 체력이 0이되면 전투종료
                                System.out.println("축하합니다. 적을 Balzac을 물리쳤습니다.!");
                                break loop;
                            }
                            else{ // 그렇지 않으면 hero_turn은 3이되고 적의 턴으로 넘어감
                                hero_turn = 3;
                                System.out.println("Balzac의 턴입니다.");
                                continue loop1;
                            }
                        }
                        if(attack_or_skill1 ==2) { // 제로의 스킬사용
                            if (zero.Mp >= 30) { // 제로의 Mp가 30보다 클 경우에 스킬사용이 가능
                                System.out.println("스킬을 사용할 대상을 고르시오. 1. 이상준 2. 제로 3. 마리 4. 그랑디엘"); // 제로의 스킬은 아군 중 한명의 물리방어력, 마법방어력을 올려주는 것이므로 한명을 선택해야함
                                int choose_one = scanner.nextInt();
                                switch (choose_one) {
                                    case 1:
                                        zero.skill(hero);
                                        hero_turn = 2;
                                        break;
                                    case 2:
                                        zero.skill(zero);
                                        hero_turn = 2;
                                        break;
                                    case 3:
                                        zero.skill(mari);
                                        hero_turn = 2;
                                        break;
                                    case 4:
                                        zero.skill(grandiel);
                                        hero_turn = 2;
                                        break;
                                }
                                System.out.println("Balzac의 턴입니다.");
                                continue loop1;
                            }
                            else { // 제로의 Mp가 부족하여 스킬사용이 불가능
                                System.out.println("제로의 Mp가 부족하여 스킬을 사용할 수 없습니다.");
                                continue loop3;
                            }
                        }
                        if(attack_or_skill1 == 3 && zero_count == 1){ // 제로의 특수스킬 사용
                            zero.Special_Skill(hero, zero, mari, grandiel, Balzac);
                            zero_count = 0;
                            hero_turn = 3;
                            System.out.println("Balzac의 턴입니다.");
                            continue loop1;
                        }
                        else{
                            System.out.println("특수스킬의 사용횟수를 초과하였습니다.");
                            continue loop3;
                        }
                    }

                    loop4:
                    while(hero_turn == 3 && Balzac.Hp >0){ // 마리의 공격순서
                        System.out.println("1. 공격한다. 2. 스킬을쓴다. 3. 특수스킬을 쓴다.");
                        int attack_or_skill2 = scanner.nextInt();
                        if(attack_or_skill2 == 1) { // 마리의 기본공격
                            mari.attack(Balzac);
                            if(Durahhan.Hp <= 0){ // 마리의 공격으로 적의 체력이 0이되면 전투종료
                                System.out.println("축하합니다. 적을 Balzac을 물리쳤습니다.!");
                                break loop;
                            }
                            else{ // 그렇지 않으면 hero_turn은 4이되고 적의 턴으로 넘어감
                                hero_turn = 4;
                                System.out.println("Balzac의 턴입니다.");
                                continue loop1;
                            }
                        }

                        if(attack_or_skill2 ==2){ // 마리의 스킬사용
                            if(mari.Mp >= 30) { // 마리의 Mp가 30보다 클 경우에 스킬사용이 가능
                                mari.skill(Balzac);
                                if(Durahhan.Hp <= 0){ // 마리의 스킬로 Balzac의 체력이 0보다 작아지면 전투 종료
                                    System.out.println("축하합니다. 적을 Balzac을 물리쳤습니다.!");
                                    break loop;
                                }
                                else{
                                    hero_turn = 4;
                                    System.out.println("Balzac의 턴입니다.");
                                    continue loop1;
                                }
                            }
                        }
                        else{ // 마리의 Mp가 부족하여 스킬사용이 불가능
                            System.out.println("마리의 Mp가 부족하여 스킬을 사용할 수 없습니다.");
                            continue loop4;
                        }

                        if(attack_or_skill2 == 3 && mari_count == 1){ // 마리의 특수스킬 사용
                            mari.Special_Skill(hero, zero, mari, grandiel, Balzac);
                            mari_count = 0;
                            if(Durahhan.Hp <= 0){
                                System.out.println("축하합니다. 적을 Balzac을 물리쳤습니다.!");
                                break loop;
                            }
                            else{
                                hero_turn = 4;
                                System.out.println("Balzac의 턴입니다.");
                                continue loop1;
                            }
                        }
                        else{
                            System.out.println("특수스킬의 사용횟수를 초과하였습니다.");
                            continue loop4;
                        }
                    }

                    loop5:
                    while(hero_turn == 4 && Balzac.Hp >0){ // 그랑디엘의 공격순서
                        System.out.println("1. 공격한다. 2. 스킬을쓴다. 3. 특수스킬을 쓴다.");
                        int attack_or_skill3 = scanner.nextInt();
                        if(attack_or_skill3 == 1) { // 마리의 기본공격
                            grandiel.attack(Balzac);
                            if(Durahhan.Hp <= 0){ // 그랑디엘의 공격으로 적의 체력이 0이되면 전투종료
                                System.out.println("축하합니다. 적을 Balzac을 물리쳤습니다.!");
                                break loop;
                            }
                            else{ // 그렇지 않으면 hero_turn은 1이되고 적의 턴으로 넘어감
                                hero_turn = 1;
                                System.out.println("Balzac의 턴입니다.");
                                continue loop1;
                            }
                        }
                        if(attack_or_skill3 == 2){ // 그랑디엘의 스킬사용
                            if(grandiel.Mp >= 30) { // 그랑디엘의 Mp가 30보다 클 경우에 스킬사용이 가능
                                System.out.println("스킬을 사용할 대상을 고르시오. 1. 이상준 2. 제로 3. 마리 4. 그랑디엘"); // 그랑디엘의 스킬은 아군 중 한명한테 힐을 해주는 것이기 때문에 한명을 선택
                                int choose_one = scanner.nextInt();
                                switch(choose_one){
                                    case 1:
                                        grandiel.skill(hero);
                                        hero_turn = 1;
                                        break;
                                    case 2:
                                        grandiel.skill(zero);
                                        hero_turn = 1;
                                        break;
                                    case 3:
                                        grandiel.skill(mari);
                                        hero_turn = 1;
                                        break;
                                    case 4:
                                        grandiel.skill(grandiel);
                                        hero_turn = 1;
                                        break;
                                }
                                System.out.println("Balzac의 턴입니다.");
                                continue loop1;
                            }
                        }
                        else{ // 그랑디엘의 Mp가 부족하여 스킬사용이 불가능
                            System.out.println("그랑디엘의 Mp가 부족하여 스킬을 사용할 수 없습니다.");
                            continue loop5;
                        }

                        if(attack_or_skill3 == 3 && grandiel_count == 1){ // 그랑디엘의 특수스킬 사용
                            grandiel.Special_Skill(hero, zero, mari, grandiel, Balzac);
                            grandiel_count = 0;
                            System.out.println("Balzac의 턴입니다.");
                            continue loop1;
                        }
                        else{
                            System.out.println("특수스킬의 사용횟수를 초과하였습니다.");
                            continue loop5;
                        }
                    }

                }
            }
        }
    }
}
