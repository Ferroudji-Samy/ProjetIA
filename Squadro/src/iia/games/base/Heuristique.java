package iia.games.base;

public interface Heuristique {

    /**
     * @param e
     * @return la valeur de l'heuristique pour le noeud
     */
        public float eval(SquadroBoard plateau);

}
