package iia.games.base;

public interface IHeuristique {

    /**
     * @param e
     * @return la valeur de l'heuristique pour le noeud
     */
        public float eval(SquadroBoard plateau);

}
