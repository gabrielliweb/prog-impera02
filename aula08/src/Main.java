import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o tamanho do seu vetor: ");
        int n = sc.nextInt();

        int[] a = new int[n];
        int[] b = new int[n];
        int[] s = new int[n];

        preencherFibonacci(a, n);
        preencherPrimos(b, n);
        somarVetores(a, b, s, n);

        imprimirVetor("a", a, n);
        imprimirVetor("b", b, n);
        imprimirVetor("s", s, n);

        imprimirMenor(s, n);

        int maior = acharMaior(s, n);
        int[] d = new int[10];
        preencheVetorDecomposicao(d, maior);

        System.out.println("Maior valor de s: " + maior);
        imprimirVetor("d", d, 10);
    }

    public static void preencherFibonacci(int[] v, int n) {
        if (n >= 1) {
            v[0] = 0;
            if (n >= 2) {
                v[1] = 1;
                for (int i = 2; i < n; i += 1) {
                    v[i] = v[i - 1] + v[i - 2];
                }
            }
        }
    }

    public static boolean ehPrimo(int x) {
        if (x < 2) {
            return false;
        }
        for (int i = 2; i < x; i += 1) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void preencherPrimos(int[] v, int n) {
        int num = 2;
        int i = 0;
        while (i < n) {
            if (ehPrimo(num)) {
                v[i] = num;
                i += 1;
            }
            num += 1;
        }
    }

    public static void somarVetores(int[] a, int[] b, int[] s, int n) {
        for (int i = 0; i < n; i += 1) {
            s[i] = a[i] + b[n - 1 - i];
        }
    }

    public static void imprimirVetor(String nome, int[] v, int n) {
        System.out.print(nome + " = [ ");
        for (int i = 0; i < n; i += 1) {
            System.out.print(v[i]);
            if (i < n - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(" ]");
    }

    public static void imprimirMenor(int[] s, int n) {
        int menorValor = s[0];
        int posicao = 0;
        for (int i = 1; i < n; i += 1) {
            if (s[i] < menorValor) {
                menorValor = s[i];
                posicao = i;
            }
        }
        System.out.println("Menor valor de s: " + menorValor + " na posicao " + posicao);
    }

    public static int acharMaior(int[] s, int n) {
        int maior = s[0];
        for (int i = 1; i < n; i += 1) {
            if (s[i] > maior) {
                maior = s[i];
            }
        }
        return maior;
    }

    public static void preencheVetorDecomposicao(int[] d, int numero) {
        for (int i = 0; i < 10; i += 1) {
            d[i] = 0;
        }
        int i = 9;
        while (numero > 0 && i >= 0) {
            d[i] = numero % 10;
            numero = numero / 10;
            i -= 1;
        }
    }
}