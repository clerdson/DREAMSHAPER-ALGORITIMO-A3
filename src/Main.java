import java.util.Scanner; // Import necessário para ler dados

class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Node head = null;
        Node tail = null;

        System.out.print("Quantos itens deseja adicionar? ");
        int quantidade = leitor.nextInt(); // Equivalente ao scanf("%d")

        for (int i = 0; i < quantidade; i++) {
            System.out.print("Digite o valor para o nó " + (i + 1) + ": ");
            int valor = leitor.nextInt();

            Node novoNo = new Node(valor);

            if (head == null) {
                head = novoNo; // Primeiro nó vira a cabeça
                tail = head;
            } else {
                tail.next = novoNo; // O atual último aponta para o novo
                tail = novoNo;      // O novo nó passa a ser o último
            }
        }

        // Exibição da lista
        System.out.println("\n--- Lista Encadeada Criada ---");
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
        System.out.print("Digite o valor que deseja buscar: ");
        int alvo = leitor.nextInt();

        buscar(head, alvo);
        leitor.close(); // Fecha o scanner
    }
    public static boolean buscar(Node head, int valorProcurado) {
        Node temp = head;
        int posicao = 0;

        while (temp != null) {
            if (temp.data == valorProcurado) {
                System.out.println("Valor " + valorProcurado + " encontrado na posicao: " + posicao);
                return true; // Encontrou!
            }
            temp = temp.next;
            posicao++;
        }

        System.out.println("Valor " + valorProcurado + " nao encontrado na lista.");
        return false; // Percorreu tudo e não achou
    }

}