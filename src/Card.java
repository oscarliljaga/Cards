/**
 * @param value 1-13
 * @param color enum CardColor {
 *              HEART,
 *              SPADE,
 *              DIAMOND,
 *              CLUB
 */
public record Card(int value, CardColor color) {
}
