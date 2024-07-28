#include <iostream>
#include <ctime>

using namespace std;

int main() {
    srand(time(0)); // imposta il seme per la generazione di numeri casuali

    cout << "Sto generando 10 numeri interi conteneti solo i valori 0 e 1 ..." << endl;

    int arrayInteri[10];
    for (int i = 0; i < 10; i++) {
        arrayInteri[i] = rand() % 2; // genera un numero casuale 0 o 1
        cout << arrayInteri[i] << " ";
    }
    cout << endl;

    int valoreZero = 0;
    for (int i = 0; i < 10; i++) {
        if (arrayInteri[i] == 0) {
            swap(arrayInteri[valoreZero], arrayInteri[i]);
            valoreZero++;
        }
    }

    cout << "Array dopo la separazione (0 all'inizio dell'array mentre 1 alla fine):" << endl;
    for (int i = 0; i < 10; i++) {
        cout << arrayInteri[i] << " ";
    }
    cout << endl;

    return 0;
}
