class PieceTriangulaire extends Piece {
    private double base;
    private double hauteur;

    public PieceTriangulaire(TypePiece typePiece, String niveau, double base, double hauteur) {
        super(typePiece, niveau);
        this.base = base;
        this.hauteur = hauteur;
    }

    @Override
    double Surface() {
        return (base * hauteur) / 2;
    }
}