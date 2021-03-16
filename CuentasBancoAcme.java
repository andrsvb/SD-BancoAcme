public class CuentasBancoAcme {

    int saldoCuenta = 0; // Saldo de la cuenta
    String titular; // Titular de la cuenta
    int numCuenta; // N. de cuenta
    static int idCuentas = 1; // Primer número de cuenta libre
    static int saldoBanco = 0; // Saldo total de todas la cuentas

    /**
     * Orientación a objetos. Variables y métodos de clase y de instancia.
     */

    CuentasBancoAcme(String Nombre, int saldoInicial) {
        this.titular = Nombre;
        if (saldoInicial >= 0) {
            this.saldoCuenta = saldoInicial;
            saldoBanco += saldoInicial;
        }
        this.numCuenta = idCuentas;
        idCuentas++;
    }


    static void imprimeDatosBanco() {
        System.out.println("Saldo total del banco: " + saldoBanco);
        System.out.println("Numero de cuentas abiertas: " + (idCuentas - 1));
    }


    void retirarDinero(int cantidad) {
        this.saldoCuenta -= cantidad;
        saldoBanco -= cantidad;
    }


    void ingresarDinero(int cantidad) {
        this.saldoCuenta += cantidad;
        saldoBanco += cantidad;
    }


    void transferencia(CuentasBancoAcme cuentaDestino, int cantidad) {
        this.retirarDinero(cantidad);
        cuentaDestino.ingresarDinero(cantidad);
    }


    void imprimeDatosCuenta() {
        System.out.println("Numero de cuenta: " + this.numCuenta);
        System.out.println("Titular: " + this.titular);
        System.out.println("Saldo actual: " + this.saldoCuenta);
    }


    public static void main(String[] args) {
// Se crea la cuenta cuyo titular es Juan con un saldo inicial de 2000
        CuentasBancoAcme cJuan = new CuentasBancoAcme("Juan", 2000);
// Se crea la cuenta cuyo titular es Pepe con un saldo inicial de 3000
        CuentasBancoAcme cPepe = new CuentasBancoAcme("Pepe", 3000);
// Se imprime los datos de la cuenta de Juan
        cJuan.imprimeDatosCuenta();
// Se imprime los datos de la cuenta de Juan
        cPepe.imprimeDatosCuenta();
// Se transfiere 1000 de la cuenta de Juan a la de Pepe
        System.out.println("--------Juan transfiere 1000 e a Pepe");
        cJuan.transferencia(cPepe, 1000);
// Se imprime los datos de la cuenta de Juan
        cJuan.imprimeDatosCuenta();
// Se imprime los datos de la cuenta de Pepe
        cPepe.imprimeDatosCuenta();
// Se imprime el saldo del banco: 5000 y el nº de cuentas creadas: 2
        CuentasBancoAcme.imprimeDatosBanco();
    }
}