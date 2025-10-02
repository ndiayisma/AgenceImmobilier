class PieceCirculaire extends Piece {
    private double rayon;

    public PieceCirculaire(TypePiece typePiece, String niveau, double rayon) {
        super(typePiece, niveau);
        this.rayon = rayon;
    }

    @Override
    double Surface() {
        return Math.PI * rayon * rayon;
    }
}