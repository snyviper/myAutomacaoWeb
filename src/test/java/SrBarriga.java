public class SrBarriga {
    VariaveisEstaticas variaveisEstaticas = new VariaveisEstaticas();
    public static void main(String[] args){

    }

    public void teste1(){
        VariaveisEstaticas.setEmail("teste@teste.com.br");
        VariaveisEstaticas.setPassword("Teste123");
        System.out.println("Teste 1"+VariaveisEstaticas.getEmail());
        System.out.println("Teste 1"+VariaveisEstaticas.getPassword());
    }
    public void teste2(){
        System.out.println("Teste 2"+VariaveisEstaticas.getEmail());
        System.out.println("Teste 2"+VariaveisEstaticas.getPassword());
    }

}
