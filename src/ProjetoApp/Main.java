package ProjetoApp;

import ProjetoApp.Data.Data;
import ProjetoApp.Modalidade.Modalidade;
import ProjetoApp.Operador.Operador;
import ProjetoApp.Unidade.Unidade;
import ProjetoApp.Hora.Hora;

import java.net.SocketOption;
import java.sql.SQLOutput;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Map<Integer, List<String>> unidadesTrabalhadasPorMes = new HashMap<>();
        Map<Integer, Set<String>> modalidadesTrabalhadasPorMes = new HashMap<>();
        Map<Integer, Integer> diasTrabalhadosPorMes = new HashMap<>();
        Map<Integer, Integer> horasTrabalhadasPorMes = new HashMap<>();

        try{
            System.out.println("Digite o Nome do Operador: ");
            String nomeOperador = input.nextLine();
            Operador operador = new Operador(nomeOperador);

            while(true){
                //DATA
                System.out.println("Dia do plantao (dd): ");
                int dia = input.nextInt();
                System.out.println("Mes do plantao (mm): ");
                int mes = input.nextInt();
                Data data = new Data(dia, mes);

                input.nextLine();

                //UNIDADE
                System.out.println("Nome da Unidade: ");
                String nomeUnidade = input.nextLine();
                Unidade unidade = new Unidade(nomeUnidade);

                //HORA
                System.out.println("Hora inicio do plantao: ");
                int horaInicio = input.nextInt();
                System.out.println("Hora fim do plantao: ");
                int horaFim = input.nextInt();
                Hora hora = new Hora(horaInicio, horaFim);

                input.nextLine();

                //MODALIDADE
                System.out.println("Modalidade (RM, TC, RX): ");
                String tipoModalidade = input.nextLine();
                Modalidade modalidade = new Modalidade(tipoModalidade);

                unidadesTrabalhadasPorMes.putIfAbsent(mes, new ArrayList<>());
                unidadesTrabalhadasPorMes.get(mes).add(unidade.getNomeDaUnidade());

                modalidadesTrabalhadasPorMes.putIfAbsent(mes, new HashSet<>());
                modalidadesTrabalhadasPorMes.get(mes).add(modalidade.getTipo());

                diasTrabalhadosPorMes.put(mes, diasTrabalhadosPorMes.getOrDefault(mes, 0) + 1);
                horasTrabalhadasPorMes.put(mes, horasTrabalhadasPorMes.getOrDefault(mes, 0) + hora.getHorasTrabalhadas());

                System.out.println("Deseja inserir outro plantao? s/n: ");
                String resposta = input.nextLine();
                if (resposta.equalsIgnoreCase("n")){
                    break;
                }

            }
            System.out.println("Operador: " + operador.getNome() + ", Id: " + operador.getId());

            for(int mes : diasTrabalhadosPorMes.keySet()){
                System.out.println("Mes: " + mes);
                System.out.println("Total de dias trabalhados: " + diasTrabalhadosPorMes.get(mes));
                System.out.println("Total de horas trabalhadas: " + horasTrabalhadasPorMes.get(mes));
                System.out.println("Unidades trabalhadas: " + unidadesTrabalhadasPorMes.get(mes));
                System.out.println("Modalidades operadas: " + modalidadesTrabalhadasPorMes.get(mes));
            }
        } catch (Exception e){
            System.out.println("Erro " + e.getMessage());
        } finally {
            input.close();
        }
    }
}