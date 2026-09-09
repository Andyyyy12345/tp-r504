def puissance(a, b):
    if not type(a) is int:
        raise TypeError("il faut que de l'int")
    if not type(b) is int:
        raise TypeError("il faut que de l'int")

    if a == 0 and b < 0:
        raise ValueError("puissance négative de zéro interdite")

    resultat = 1

    if b >= 0:
        for i in range(b):
            resultat = resultat * a
    else:
        for i in range(-b):
            resultat = resultat * a
        resultat = 1 / resultat

    return resultat
