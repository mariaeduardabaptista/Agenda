import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {

    
        int opcao, totalContatos = 0;
        Scanner ler = new Scanner(System.in);
        Contato[] contatos = new Contato[0];


        do {
            exibeMenu();
            opcao = ler.nextInt();
            ler.nextLine();

            switch(opcao){
                case 1: 
                 System.out.println("Digite o total de contatos que deseja cadastrar");
                 totalContatos = ler.nextInt();
                 ler.nextLine();
                 Contato[] aux = new Contato[totalContatos];
                 contatos = aux;

                 for(int i=0; i < totalContatos; i++){
                     Contato contato = new Contato(totalContatos);

                     System.out.println("\nDigite o codigo:");
                     contato.setCodigo(ler.nextInt());
                     ler.nextLine();

                     System.out.println("\nDigite o nome:");
                     contato.setNome(ler.nextLine());
                     
                     System.out.println("\nDigite o telefone");
                     contato.setTelefone(ler.nextLine());

                     contatos[i] = contato;
                 }
                 break;

                case 2:
                listaDeContato(totalContatos, contatos);
                 break;

                case 3:
                 acharCodigo(totalContatos, ler, contatos);
                 break;

                case 4:
                acharNome(totalContatos, ler, contatos);
                 break;

                case 0:
                System.out.println("Encerrando a aplicação. Volte sempre! ");
                 break;
                default:
                  System.out.println(" Opção invalida.Verifique! ");
            }

        } while (opcao != 0);

        ler.close();

    }

    private static void listaDeContato(int totalContatos, Contato[] contatos) {
        System.out.println("\nLista de contatos:");
        for(int i = 0; i < totalContatos; i++){
            System.out.printf("\nCodigo: %d", contatos[i].getCodigo());
            System.out.printf("\nNome:%s", contatos[i].getNome());
            System.out.printf("\nTelefone: %s ", contatos[i].getTelefone());
        }
    }

    private static void acharCodigo(int totalContatos, Scanner ler, Contato[] contatos) {
        boolean achei;
        System.out.println("\nDigite o codigo do contato a localizar");
         int codigo = ler.nextInt();
         achei = false;
         ler.nextLine();
         for(int i = 0; i<totalContatos; i++){
             if(contatos[i].getCodigo() == codigo){
                System.out.printf("\nCodigo: %d", contatos[i].getCodigo());
                System.out.printf("\nNome:%s", contatos[i].getNome());
                System.out.printf("\nTelefone: %s ", contatos[i].getTelefone());
                achei = true;
                break;
             }
         }
        if (achei == false){
         System.out.println("\nNão encontrei o codigo solicidado! ");
        }
    }

    private static void acharNome(int totalContatos, Scanner ler, Contato[] contatos) {
        boolean achei;
        System.out.println("\nDigite o nome do contato a localizar");
         String nome = ler.nextLine();
         achei = false;
        
         for(int i = 0; i<totalContatos; i++){
             if(contatos[i].getNome().equals(nome)){
                System.out.printf("\nCodigo: %d", contatos[i].getCodigo());
                System.out.printf("\nNome:%s", contatos[i].getNome());
                System.out.printf("\nTelefone: %s ", contatos[i].getTelefone());
                achei = true;
                break;
             }
         }
        if (achei == false)
         System.out.println("\nNão encontrei o contato ");
    }

    private static void exibeMenu() {
        System.out.println("\nDigite a opção desejada ");
        System.out.println("1 - Cadastrar cantato ");
        System.out.println("2 - Listar todos os contatos ");
        System.out.println("3 - Localizar contatos por código ");
        System.out.println("4 - Localizar contato por nome ");
        System.out.println("0 - Sair ");
    }

}
