class Calculadora:
    def sumar(self, a, b):
        return a + b

    def restar(self, a, b):
        return a - b

    def multiplicar(self, a, b):
        return a * b

    def dividir(self, a, b):
        if b == 0:
            return "Error: No se puede dividir por cero."
        return a / b

# Menú interactivo
calculadora = Calculadora()

while True:
    print("\n--- Calculadora ---")
    print("1. Sumar")
    print("2. Restar")
    print("3. Multiplicar")
    print("4. Dividir")
    print("5. Salir")
    opcion = input("Elige una opción: ")

    if opcion == "5":
        print("¡Adiós!")
        break

    num1 = float(input("Ingresa el primer número: "))
    num2 = float(input("Ingresa el segundo número: "))

    if opcion == "1":
        print("Resultado:", calculadora.sumar(num1, num2))
    elif opcion == "2":
        print("Resultado:", calculadora.restar(num1, num2))
    elif opcion == "3":
        print("Resultado:", calculadora.multiplicar(num1, num2))
    elif opcion == "4":
        print("Resultado:", calculadora.dividir(num1, num2))
    else:
        print("Opción no válida.")