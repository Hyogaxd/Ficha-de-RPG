package RPG;
import java.util.Scanner;
public class v005 {

    public class LeituraCaractere {
         Scanner scanner = new Scanner(System.in);
         char caractere = scanner.next().charAt(0);
         }
    public static void main(String[] args){
        
        String personagem = "", guilda = "", opcao;
        String[] item = {"Zweihander", "Cajado", "Adaga"};
        int[] dano = {3, 1, 2};
        int[] alcance = {2, 10, 1};
        String classe = "";
        String[] classeRE = {"G", "M", "L"};
        double força = 0, destreza = 0, inteligencia = 0, vitalidade = 0;
        int pedido, pontos, arma = 0, aux = 0;
        boolean logico = false;
        double bonux = 0;
        double pontosmx = 48;
        int lp = 0;
       
        Scanner leia = new Scanner (System.in);

        do {
            System.out.println("1 - Criar boneco ");
            System.out.println("2 - Armas ");
            System.out.println("3 - Exibir Ficha ");
            System.out.println("4 - Exit ");
            int option = leia.nextInt();
            
            if (option == 1){
                logico = false;
                System.out.println("Nome da sua persona");
                personagem = leia.next();
                leia.nextLine();
                System.out.println(("Selecione [G] Guerreiro, [M] Mago, [L] Ladrão: "));
                    classe = leia.next().trim();
                    leia.nextLine();
                while(!classe.equalsIgnoreCase("G") && !classe.equalsIgnoreCase("M") && !classe.equalsIgnoreCase("L")){
                    System.out.println("Erro na criação tente novamente");
                    System.out.println(("Selecione [G] Guerreiro, [M] Mago, [L] Ladrão: "));
                    classe = leia.next().trim();
                    leia.nextLine();
                }

                System.out.println("Nome da sua Guilda: ");
                guilda = leia.next();
                leia.nextLine();

                System.out.println("Pontos maximo: "+ pontosmx + " Diga sua Força(faixa:3 a 18): ");
                força = leia.nextInt();
                leia.nextLine();
                    System.out.println("Pontos maximo: " + (pontosmx - força) + " Diga Sua Destreza(faixa:3 a 18): ");
                    destreza = leia.nextInt();
                    leia.nextLine();
                        System.out.println("Pontos maximo: " + (pontosmx - (força + destreza)) + " Diga Sua Inteligencia(faixa:3 a 18): ");
                        inteligencia = leia.nextInt();
                        leia.nextLine();
                            System.out.println("Pontos maximo: " + (pontosmx - (força + destreza + inteligencia)) + " Diga sua Vitalidade(faixa:3 a 18)");
                            vitalidade = leia.nextInt();
                            leia.nextLine();
                            
                if(força < 3 || força > 18){
                    System.out.println("Numero de força excedido, tente novamente");
                }else if(destreza < 3 || destreza > 18){
                    System.out.println("Numero de destreza excedido, tente novamente");
                }else if(inteligencia < 3 || inteligencia > 18){
                    System.out.println("Numero de inteligencia excedido, tente novamente");
                }else if(vitalidade < 3 || vitalidade > 18){
                    System.out.println("Numero de vitalidade excedido, tente novamente");
                }else{
                }
                logico = true;
            }
            else if (option == 2 && logico == true){
                System.out.println("Escolha uma das Armas selecionadas: ");
                System.out.println("|   | Item | Dano(d6) | Alcance(m) | Classe requerida | ");
                System.out.println("| 1 | "+ item[0]+ "   |   "+ dano[0]+  "   |   "+ alcance[0]+ "   |   "+ classeRE[0] + "   | ");
                System.out.println("| 2 | "+ item[1]+ "   |   "+ dano[1]+  "   |   "+ alcance[1]+ "   |   "+ classeRE[1] + "   | ");
                System.out.println("| 3 | "+ item[2]+ "   |   "+ dano[2]+  "   |   "+ alcance[2]+ "   |   "+ classeRE[2] + "   | ");
                arma = leia.nextInt();
                leia.nextLine();
                if (arma >= 1 && arma <= 3){
                    if (classe.equalsIgnoreCase(classeRE[arma - 1])){
                        aux = arma - 1;
                        System.out.println(item[aux] + " Arma equipiada ");
                    }else {
                        System.out.println("Item não e da sua classe");
                    }
                }else{
                    System.out.println("Opção invalida");
                }
            }

            
            else if (option == 3){

                if (classe.equalsIgnoreCase("G")){
                    System.out.println(bonux = 2);
                }else if (classe.equalsIgnoreCase("M")){
                    
                    System.out.println(bonux = 4);
                }else if (classe.equalsIgnoreCase("L")){
                    
                    System.out.println(bonux = 2);
                }

                double hp = (força + vitalidade) / 4.0;
                double mp = (inteligencia + vitalidade) / 4.0;
                double fp = vitalidade;
                double spd = (destreza + vitalidade) / 4.0;
                double inicio = spd * 10.0;

                System.out.println("========================================");
                System.out.println("-----------------FICHA------------------");
                System.out.println("========================================");
                System.out.println("Nome: " + personagem + " | " + "Guilda: " + guilda + " | " + "Classe: " + classe + " | " + "Arma: " + item[arma - 1] );
                System.out.println("========================================");
                System.out.println("ATRIBUTOS BASE: ");
                if (classe.equalsIgnoreCase("G")){
                    System.out.println("Força: "+ força + " Destreza: "+  destreza+ " Inteligencia: "+ inteligencia + " Bonus de classe:" + bonux + " FORÇA");
                }else if (classe.equalsIgnoreCase("M")){
                    System.out.println("Força: "+ força + " Destreza: "+  destreza+ " Inteligencia: "+ inteligencia + " Bonus de classe:" + bonux + " INTELIGENCIA");
                }else if (classe.equalsIgnoreCase("L")){
                    System.out.println("Força: "+ força + " Destreza: "+  destreza+ " Inteligencia: "+ inteligencia + " Bonus de classe:" + bonux + " INTELIGENCIA E DESTREZA");
                }
                System.out.println("========================================");
                System.out.println("ATRIBUTOS DERIVADOS: ");
                System.out.println("Pontos de vida: "+ hp);
                System.out.println("Pontos de Magia: "+ mp);
                System.out.println("Limite de Fadiga: "+ fp);
                System.out.println("Velocidade base: "+ spd);
                System.out.println("Valor de Iniciativa: "+ inicio);
                System.out.println("========================================");
            }
            else if(option == 4){
                System.out.println("Mas ja, Ate uma proxima ");
            }else{
                System.out.println(("Invalido, Tente novamente "));
            }
            } while ( lp != 4);
            

    
        
    }
}
