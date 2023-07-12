package org.rdurandk.junit5app.ejemplos.models;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.rdurandk.junit5app.ejemplos.exceptions.DineroInsuficienteException;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)//no es buena practica
class CuentaTest {//por cada llamada a un metodo test la instancia de la clase se crea por debajo
    Cuenta cuenta;
    @BeforeEach
    void initMetodoTest(){//el metodo ejecutara antes de cada test
        this.cuenta = new Cuenta("Alex", new BigDecimal("1000.12345"));
        System.out.println("Iniciando el metodo");
    }

    @AfterEach
    void tearDown() {////el metodo ejecutara despues de cada test
        System.out.println("finalizando el metodo de prueba.");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("inicializando el test");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("finalizando el test");
    }

    @Nested
    @DisplayName("probando atributos de la cuenta corriente")
    class CuentaTestNombreSaldo{
        @Test//para indicar que esta prueba se tiene que ejecutar en el runner de nuestro programa
        @DisplayName("el nombre")//un nombre para el test
        void test_nombre_cuenta() {
            //cuenta.setPersona("Alex");
            String esperado = "Alex";
            String real = cuenta.getPersona();
            assertNotNull(real, () -> "la cuenta no puede ser nula");
            //Assertions.assertEquals(esperado, real);
            assertEquals(esperado, real, () -> "el nombre de la cuenta no es el que se esperaba: se esperaba "
                    + esperado + ", sinb embargo fue " + real);//modo static
            assertTrue(real.equals("Alex"), () -> "nombre cuenta esperada debe ser igual a la real");
        }

        @Test
        @DisplayName("el saldo, que no sea null, mayor que cero, valor esperado")
        void testSaldoCuenta() {
            assertNotNull(cuenta.getSaldo());
            assertEquals(1000.12345, cuenta.getSaldo().doubleValue());
            assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
            //cuenta.getSaldo().compareTo(BigDecimal.ZERO)quiere decir saldo es menor que cero?
        }

        @Test
        @DisplayName("testeando referencias que sean iguales con el metodo equals")
        void testReferenciaCuenta() {
            cuenta = new Cuenta("John Doe", new BigDecimal("8900.9997"));
            Cuenta cuenta2 = new Cuenta("John Doe", new BigDecimal("8900.9997"));

            //assertNotEquals(cuenta, cuenta2);
            assertEquals(cuenta, cuenta2);//evaluando por medio de equals en la clase cuenta
        }
    }

    @Nested
    class CuentaOperacionesTest{
        @Test
        void testDebitoCuenta() {
            cuenta.debito(new BigDecimal(100));
            assertNotNull(cuenta.getSaldo());
            assertEquals(900, cuenta.getSaldo().intValue());
            assertEquals("900.12345", cuenta.getSaldo().toString());
        }

        @Test
        void testCreditoCuenta() {
            cuenta.credito(new BigDecimal(100));
            assertNotNull(cuenta.getSaldo());
            assertEquals(1100, cuenta.getSaldo().intValue());
            assertEquals("1100.12345", cuenta.getSaldo().toString());
        }
        @Test
        void tesstTrasnferirDineroCuentas() {
            Cuenta cuenta1 = new Cuenta("Jhon Doe", new BigDecimal("2500"));
            Cuenta cuenta2 = new Cuenta("Alex", new BigDecimal("1500.8989"));
            Banco banco = new Banco();
            banco.setNombre("Banco del Estado");
            banco.transferir(cuenta2, cuenta1, new BigDecimal(500));
            assertEquals("1000.8989", cuenta2.getSaldo().toPlainString());
            assertEquals("3000", cuenta1.getSaldo().toPlainString());
        }
    }



    @Test
    void testDineroInsuficienteExceptionCuenta() {
        Exception exception = assertThrows(DineroInsuficienteException.class, () -> {
            cuenta.debito(new BigDecimal(1500));
        });
        String actual = exception.getMessage();
        String esperado = "Dinero Insuficiente";
        assertEquals(esperado, actual);
    }



    @Test
    //@Disabled
    @DisplayName("probando relaciones entre las cuentas y el banco con asertAll")
    void testRelacionBancoCuentas() {
        //fail();//aseguramos de q' falle el metodo
        Cuenta cuenta1 = new Cuenta("Jhon Doe", new BigDecimal("2500"));
        Cuenta cuenta2 = new Cuenta("Alex", new BigDecimal("1500.8989"));

        Banco banco = new Banco();
        banco.addCuenta(cuenta1);
        banco.addCuenta(cuenta2);

        banco.setNombre("Banco del Estado");
        banco.transferir(cuenta2, cuenta1, new BigDecimal(500));
        assertAll(() -> assertEquals("1000.8989", cuenta2.getSaldo().toPlainString(),
                        () -> "el valor del saldo de la cuenta2 no es el esperado"),
                () -> assertEquals("3000", cuenta1.getSaldo().toPlainString(),
                        () -> "el valor del saldo de la cuenta1 no es el esperado"),
                () -> assertEquals(2, banco.getCuentas().size(),
                        () -> "el banco no tiene la cuentas esperadas"),
                () -> assertEquals("Banco del Estado", cuenta1.getBanco().getNombre()),
                () -> assertEquals("Alex", banco.getCuentas().stream()
                        .filter(c -> c.getPersona().equals("Alex"))
                        .findFirst()
                        .get().getPersona()),
                () -> assertTrue(banco.getCuentas().stream()
                        .anyMatch(c -> c.getPersona().equals("Jhon Doe"))));
    }
    @Nested
    class SystemaOperativoTest{
        @Test
        @EnabledOnOs(OS.WINDOWS)
        void testSoloWindows(){

        }
        @Test
        @EnabledOnOs({OS.LINUX, OS.MAC})
        void testSoloLinux(){
        }
        @Test
        @DisabledOnOs(OS.WINDOWS)
        void testNoWindows() {
        }
    }

    @Nested
    class JavaVersionTest {
        @Test
        @EnabledOnJre(JRE.JAVA_8)
        void soloJdk8() {

        }
        @Test
        @EnabledOnJre(JRE.JAVA_16)
        void soloJdk16() {
        }
        @Test
        @DisabledOnJre(JRE.JAVA_16)
        void soloNoJdk16() {
        }
    }

    @Nested
    class SistemPropertiesTest{
        @Test
        void imprimirSystemProperties() {
            Properties properties = System.getProperties();
            properties.forEach((k,v)-> System.out.println(k + ":" +v));
        }
        @Test
        @EnabledIfSystemProperty(named = "java.version", matches = "16.0.1")
        void testJavaVersion() {
        }
        @Test
        @EnabledIfSystemProperty(named = "os.arch", matches = ".*64.*")
        void testSolo64() {
        }
        @Test
        @DisabledIfSystemProperty(named = "os.arch", matches = ".*64.*")
        void testNo64() {
        }
        @Test
        @EnabledIfSystemProperty(named = "user.name", matches = "alex")
        void testUsername() {
        }
        @Test
        @EnabledIfSystemProperty(named = "ENV", matches = "dev")
        void testDev() {
        }
    }

    @Nested
    class VariableAmbienteTest{
        @Test
        void imprimirVariablesAmbiente() {
            Map<String, String> getenv = System.getenv();
            getenv.forEach((k,v)-> System.out.println(k + " = " + v));
            //System.out.println(getenv.get("LOGONSERVER"));
        }

        @Test
        @EnabledIfEnvironmentVariable(named = "USERDOMAIN", matches = "DESKTOP-SIC78G3")
        void testUserDomain(){

        }

        @Test
        @EnabledIfEnvironmentVariable(named = "NUMBER_OF_PROCESSORS", matches = "6")
        void testProcesadores(){

        }

        @Test
        @EnabledIfEnvironmentVariable(named = "ENVIRONMENT", matches = "DEV")
        void testEnv(){

        }


    }


    @Test
    @DisplayName("test Saldo Cuenta Dev")
    void testSaldoCuentaDev() {
        boolean esDev = "dev".equals(System.getProperty("ENV"));
        assumeTrue(esDev);
        assertNotNull(cuenta.getSaldo());
        assertEquals(1000.12345, cuenta.getSaldo().doubleValue());
        assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);
        assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        //cuenta.getSaldo().compareTo(BigDecimal.ZERO)quiere decir saldo es menor que cero?
    }
    @Test
    @DisplayName("test Saldo Cuenta Dev 2")
    void testSaldoCuentaDev2() {
        boolean esDev = "dev".equals(System.getProperty("ENV"));
        assumingThat(esDev, ()->{
            assertNotNull(cuenta.getSaldo());
            assertEquals(1000.12345, cuenta.getSaldo().doubleValue());
            assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        });
    }

    @DisplayName("Probando Debito Cuenta Repetir!")
    @RepeatedTest(value = 5, name = "{displayName} -Repeticion numero {currentRepetition} de {totalRepetitions}")
    void testDebitoCuentaRepetir(RepetitionInfo info) {//el parametro nos sirve para saber en que index estamos
        if(info.getCurrentRepetition() == 3){
            System.out.println("estamos en la repeticion " + info.getCurrentRepetition());
        }
        cuenta.debito(new BigDecimal(100));
        assertNotNull(cuenta.getSaldo());
        assertEquals(900, cuenta.getSaldo().intValue());
        assertEquals("900.12345", cuenta.getSaldo().toString());
    }
}