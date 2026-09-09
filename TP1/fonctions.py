def puissance(a, b):
    if not type(a) is int:
        raise TypeError("il faut que de l'int")
    if not type(b) is int:
        raise TypeError("il faut que de l'int")

    if a == 0 and b < 0:
        raise ValueError("puissance négative de zéro interdite")

    return a ** b
