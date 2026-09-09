def puissance(a, b):
    if not type(a) is int:
        raise TypeError("il faut que de l'int")
    if not type(b) is int:
        raise TypeError("il faut que de l'int")
    return a ** b

