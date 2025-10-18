/*
 Curso: Bacharelado em Ciencia da Computacao
 Disciplina: Resolucao de Problemas Estruturados em Computacao
 Professor: Andrey Cabral Meira
 Periodo: 4
 Turma: B
 Integrantes:
  - Adryan Costa Silva
  - Hassan Ali El Gazouini
  - Hussein Ali El Gazouini
  - Murilo Zimerman Fortaleza
*/

import java.util.Scanner;

class Nodo {
    char value; // Valor do nodo pode ser uma letra ou um Numero por isso usamos char
    Nodo left; // seria o ponto (.)
    Nodo right; // seria o traco (-)

    Nodo(char value) {
        this.value = value;
        right = null;
        left = null;
    }
}

class ArvoreBinariaMorse {
    Nodo root;

    // inicializa a arvore com nodo raiz vazio
    void inicializar() {
        root = new Nodo(' '); // raiz vazia, nao armazena letra
    }

    // Inserir letra ou numero na arvore
    void inserir(char value, String code) {
        Nodo atual = root;

        for (int i = 0; i < code.length(); i++) {
            char simbolo = code.charAt(i);

            if (simbolo == '.') { // "." = esquerda
                if (atual.left == null) {
                    atual.left = new Nodo(' '); // criar nodo vazio
                }
                atual = atual.left;
            } else if (simbolo == '-') { // "-" = direita
                if (atual.right == null) {
                    atual.right = new Nodo(' '); // criar nodo vazio
                }
                atual = atual.right;
            }
        }
        atual.value = value; // colocar letra no nodo final
    }

    // Buscar a letra na arvore
    public char buscar(String code) {
        Nodo atual = root;

        for (int i = 0; i < code.length(); i++) {
            char simbolo = code.charAt(i);

            if (simbolo == '.') {
                if (atual.left == null) {
                    System.out.println("Nao encontrado");
                }
                atual = atual.left;
            } else if (simbolo == '-') {
                if (atual.right == null) {
                    System.out.println("Nao encontrado");
                }
                atual = atual.right;
            }
        }

        return atual.value;
    }

    void remover(String code) {
        Nodo atual = root;

        // anda a arvore conforme o codigo morse
        for (int i = 0; i < code.length(); i++) {
            atual = (code.charAt(i) == '.') ? atual.left : atual.right;
            if (atual == null) {
                System.out.println("Nodo nao encontrado!");
                return;
            }
        }

        // Limpa o valor do nodo
        atual.value = ' ';
        System.out.println("Nodo removido!");
    }

    void exibirArvore(Nodo nodo, int nivel, String prefixo) {
        if (nodo == null) return;

        // printar a raiz  como ( ) so para visualizar
        if (nivel == 0) {
            System.out.println("( " + nodo.value + " )");
        } else {
            // indentacao (3 espacos por nivel)
            for (int i = 0; i < nivel; i++) System.out.print("   ");
            System.out.println(prefixo + ": " + nodo.value);
        }

        //Esquerda primeiro
        exibirArvore(nodo.left, nivel + 1, "E");
        //Direita segundo
        exibirArvore(nodo.right, nivel + 1, "D");
    }



}

public class Main {
    public static void main(String[] args) {

        ArvoreBinariaMorse arvore = new ArvoreBinariaMorse();
        arvore.inicializar();
        Scanner sc = new Scanner(System.in);
        

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Inserir letra/numero em Morse");
            System.out.println("2. Buscar letra/numero em Morse");
            System.out.println("3. Remover letra/numero em Morse ");
            System.out.println("4. Exibir arvore Morse");
            System.out.println("5. Mostrar Alfabeto Morse");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opcao: ");
            int opcao = sc.nextInt();

            if (opcao == 1) {
                System.out.print("Digite SOMENTE a letra/numero: ");
                char letra = sc.next().charAt(0);
                System.out.print("Digite SOMENTE o codigo Morse: ");
                String codigo = sc.next();
                arvore.inserir(letra, codigo);
            } else if (opcao == 2) {
                System.out.print("Digite o codigo Morse: ");
                String codigo = sc.next();
                System.out.println("Resultado: " + arvore.buscar(codigo));
            } else if (opcao == 3) {
                System.out.print("Digite o codigo Morse: ");
                String codigo = sc.next();
                arvore.remover(codigo);
            } else if (opcao == 4) {
                arvore.exibirArvore(arvore.root, 0, "");
            }else if (opcao == 5) {
            System.out.println("""
                Alfabeto Morse:
                A : .-
                B : -...
                C : -.-.
                D : -..
                E : .
                F : ..-.
                G : --.
                H : ....
                I : ..
                J : .---
                K : -.-
                L : .-..
                M : --
                N : -.
                O : ---
                P : .--.
                Q : --.-
                R : .-.
                S : ...
                T : -
                U : ..-
                V : ...-
                W : .--
                X : -..-
                Y : -.--
                Z : --..

                1 : .----
                2 : ..---
                3 : ...--
                4 : ....-
                5 : .....
                6 : -....
                7 : --...
                8 : ---..
                9 : ----.
                0 : -----
                """);
            }
            else if (opcao == 6) {
                System.out.println("Saindo...");
                break;
            } else {
                System.out.println("Opcao invalida. Tente novamente.");
            }
        }


        // ArvoreBinariaMorse arvore = new ArvoreBinariaMorse();
        // arvore.inicializar();


        // // Inserindo letras de teste
        // arvore.inserir('S', "...");
        // arvore.inserir('O', "---");
        // arvore.inserir('E', ".");
        // arvore.inserir('0', "-----");
        // arvore.inserir('1', ".----");

        // // Exibindo arvore
        // System.out.println("Arvore Binaria Morse: \n");
        // arvore.exibirArvore(arvore.root, 0, "");

        // // Testando busca
        // System.out.println("Busca '...': " + arvore.buscar("..."));
        // System.out.println("Busca '---': " + arvore.buscar("---"));
        // System.out.println("Busca '.': " + arvore.buscar("."));
        // System.out.println("Busca '-----': " + arvore.buscar("-----"));

    }
}
