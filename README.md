# Projeto: Árvores Binárias com Código Morse

## Curso

Bacharelado em Ciência da Computação

## Disciplina

Resolução de Problemas Estruturados em Computação

## Professor

Andrey Cabral Meira

## Período

4

## Turma

B

## Integrantes

* Adryan Costa Silva
* Hassan Ali El Gazouini
* Hussein Ali El Gazouini
* Murilo Zimerman Fortaleza

## Descrição do Projeto

Este projeto implementa uma árvore binária para representar o Código Morse. Cada nó da árvore representa uma letra ou número, e o caminho da raiz até o nó corresponde à sequência de pontos (`.`) e traços (`-`) do código Morse. O programa permite inserir, buscar, remover e exibir os caracteres em Morse.

---

## Como Rodar

1. Certifique-se de ter **Java** instalado.
2. Compile o programa:

```bash
javac Main.java
```

3. Execute o programa:

```bash
java Main
```

4. Você verá o **menu interativo** no console.

---

## Menu do Programa

O programa possui as seguintes opções:

1. **Inserir letra/número em Morse**
   Permite inserir manualmente uma letra ou número na árvore, fornecendo o código Morse correspondente.

2. **Buscar letra/número em Morse**
   Busca um caractere na árvore a partir do código Morse fornecido.

3. **Remover letra/número em Morse**
   Remove o caractere correspondente ao código Morse fornecido.

4. **Exibir árvore Morse**
   Mostra a árvore binária de forma hierárquica, com indentação para cada nível.

5. **Mostrar Alfabeto Morse**
   Exibe todas as letras e números com seus respectivos códigos Morse.

6. **Inserir manualmente todas as letras e números**
   Insere todas as letras do alfabeto e números de 0 a 9 na árvore usando `arvore.inserir()`.

7. **Sair**
   Encerra o programa.

---

## Estrutura do Código

### Classe `Nodo`

* **Descrição:** A classe nodo representa um nodo mesmo em uma árvore binária. Cada nodo guarda um número, uma letra ou pode estar vazio.
* **Atributos:**

  * `char value`: Guarda o caractere, que pode ser uma letra ou número de 0 a 9.
  * `Nodo left`: Ponta para o nodo filho na esquerda. Em código Morse, filho na esquerda significa um ".".
  * `Nodo right`: Ponta para o nodo filho na direita. Em código Morse, filho na direita significa um "-".
* **Construtor:** Quando um novo nodo é criado:

  1. `value` é igual ao caractere passado, por exemplo 'A' ou '1'.
  2. `left` e `right` são inicializados como nulos porque ainda não têm filhos.

Exemplo:
`Nodo n = new Nodo('A');`
Cria um nodo guardando 'A', sem filhos.


### Classe `ArvoreBinariaMorse`

* **Descrição:** Essa classe representa a árvore binária do código Morse. Ela guarda a raiz da árvore e os métodos para inserir, buscar, remover e exibir os caracteres.
* **Atributos:**

  * `Nodo root`: Guarda o nodo raiz da árvore, que começa vazio.

#### Métodos

1. **`void inicializar()`**

   * Cria um novo nodo raiz vazio (`value = ' '`), sem filhos.

2. **`void inserir(char value, String code)`**

   * Começa do nodo raiz.
   * Para cada símbolo do código Morse:

     * Se for ponto (`.`), vai para o filho esquerdo. Se não existir, cria um nodo vazio.
     * Se for traço (`-`), vai para o filho direito. Se não existir, cria um nodo vazio.
   * No final do código, coloca o `value` no nodo atual.
   * **Exemplo:** `inserir('U', '..-')` vai criar ou usar os nodos: raiz -> left -> left -> right e coloca 'U' nesse nodo final.

3. **`char buscar(String code)`**

   * Começa do nodo raiz.
   * Para cada símbolo do código Morse:

     * Se for ponto (`.`), vai para o filho esquerdo.
     * Se for traço (`-`), vai para o filho direito.
   * Retorna o valor do nodo no final do código.
   * **Exemplo:** `buscar('..-')` começa na raiz, vai left (.), left (.), right (-), e retorna o valor desse nodo que é 'U'.

4. **`void remover(String code)`**

   * Começa do nodo raiz.
   * Percorre a árvore conforme o código Morse.
   * Quando chega no nodo final, apaga o `value` (coloca `' '`), mas mantém a árvore.
   * **Exemplo:** `remover('..-')` vai até o nodo do 'U' e apaga o 'U', mas os nodos continuam lá.

5. **`void exibirArvore(Nodo nodo, int nivel, String prefixo)`**

   * Exibe o valor do nodo atual.
   * Adiciona espaços para mostrar a hierarquia (3 espaços por nível).
   * Primeiro exibe o filho esquerdo (ponto), depois o filho direito (traço).
   * **Exemplo:** mostrando `..-` na árvore, você verá a hierarquia raiz -> left -> left -> right com 'U' no final.


---

## Exemplos de Uso

<img width="797" height="702" alt="image" src="https://github.com/user-attachments/assets/83935d35-b0f4-4f15-a4d3-6ac8c4dbf17c" />


---

## Visualização da Árvore (Exemplo)

```
(   )
   E: E
      E: I
         E: S
            E: H
               E: 5
               D: 4
            D: V
               D: 3
         D: U
            E: F
            D:
               D: 2
      D: A
         E: R
            E: L
         D: W
            E: P
            D: J
               D: 1
   D: T
      E: N
         E: D
            E: B
               E: 6
            D: X
         D: K
            E: C
            D: Y
      D: M
         E: G
            E: Z
               E: 7
            D: Q
         D: O
            E:
               E: 8
            D:
               E: 9
               D: 0
```
