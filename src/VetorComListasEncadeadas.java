import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class VetorComListasEncadeadas {
    public static void main(String[] args) {
        int x = 0;
        boolean u = true;
        while (u) {
            Scanner sc = new Scanner(System.in);
            int op;

            while (true) {
                try {
                    System.out.println("Digite o Tamanho do Número de posições:");
                    op = Integer.parseInt(sc.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Digite apenas números!!!");
                }
            }
            int tamanhoDoVetor = op;
            LinkedList<String>[] vetorDeListas = new LinkedList[tamanhoDoVetor];
            // Inicializando cada índice do vetor com uma nova lista encadeada
            for (int i = 0; i < tamanhoDoVetor; i++) {
                vetorDeListas[i] = new LinkedList<>();
            }
            System.out.println("Copie e cole o caminho do arquivo onde o alunosED_2023.txt está (com o nome do arquivo incluso) :");
            String c = sc.nextLine();
            int lineCount = 0;
            try (BufferedReader reader = new BufferedReader(new FileReader(c))) {
                while (reader.readLine() != null) {
                    lineCount++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            String[] lines = new String[lineCount];
            try (BufferedReader reader = new BufferedReader(new FileReader(c))) {
                String line;
                int index = 0;
                while ((line = reader.readLine()) != null) {
                    lines[index] = line;
                    index++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(x>3){
                System.out.println("Deseja antecipar a saída do programa?s/n");
                String z = sc.nextLine().toLowerCase(Locale.ROOT);
                if (z.equals("s")){
                    u = false;
                }
            }
            if (x > 0) {
                System.out.println("Editar as constantes da função hash (p(primo) * (h + line.charAt(c))) % M):");
                int o = 0;
                int h = 0;
                int l = 0;
                int m = 1;
                while (true) {
                    try {
                        System.out.println("Digite o Número primo:");
                        o = Integer.parseInt(sc.nextLine());
                        try {
                            System.out.println("Digite a posição do caractere c (0 a 9):");
                            l = Integer.parseInt(sc.nextLine());
                            try {
                                System.out.println("Digite o Número M :");
                                m = Integer.parseInt(sc.nextLine());
                                for (String line : lines) {
                                    h = (o * (h + line.charAt(l))) % m;
                                    vetorDeListas[h].add(line);
                                    h = 0;
                                }
                                break;
                            }catch (NumberFormatException e){
                                System.out.println("Digite apenas números!!!");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Digite apenas números!!!");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Digite apenas números!!!");
                    }
                }
            }else {
                System.out.println("Função Hash padrão (29 * (h + line.charAt(0))) % M);");
                int h = 0;
                for (String line : lines) {
                    h = (29 * (h + line.charAt(0))) % op;
                    vetorDeListas[h].add(line);
                    h = 0;
                }

            }
            String caminhoPasta = "C:\\trabHash";
            File pasta = new File(caminhoPasta);
            if (!pasta.exists()) {
                boolean criadoComSucesso = pasta.mkdirs();
                if (criadoComSucesso) {
                    System.out.println("Pasta criada com sucesso.");
                } else {
                    System.out.println("Não foi possível criar a pasta.");
                }
            } else {
                System.out.println("A pasta já existe.");
            }
            List<String[]> data = new ArrayList<>();
            int j = 0;
            for (int i = 0; i < tamanhoDoVetor; i++) {
                System.out.print("Lista " + i + ": ");
                for (String elemento : vetorDeListas[i]) {
                    System.out.print(elemento + "->");
                    j++;
                }
                data.add(new String[]{String.valueOf(i), String.valueOf(j)});
                j = 0;
                System.out.println();
            }
            String csvFile = "C:\\trabHash\\OcorrIndice" + x + "Qnt.csv";
            try (PrintWriter writer = new PrintWriter(new FileWriter(csvFile))) {
                for (String[] rowData : data) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < rowData.length; i++) {
                        sb.append(rowData[i]);
                        if (i < rowData.length - 1) {
                            sb.append(",");
                        }
                    }
                    writer.println(sb);
                }
                System.out.println("Arquivo CSV criado com sucesso.");
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println();
            System.out.println("Deseja encerrar o programa?s/n");
            String v = sc.nextLine().toLowerCase(Locale.ROOT);
            if (v.equals("s")){
                u = false;
            }
            x++;
        }
    }
}

