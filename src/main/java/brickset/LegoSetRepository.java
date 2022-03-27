package brickset;

import repository.Repository;

/**
 * Represents a repository of {@code LegoSet} objects.
 */
public class LegoSetRepository extends Repository<LegoSet>
{
    public LegoSetRepository()
    {
        super(LegoSet.class, "brickset.json");
    }

    /**
     * Returns the number of LEGO sets with the theme specified.
     *
     * @param theme a LEGO set theme
     * @return the number of LEGO sets with the theme specified
     */
    public long countLegoSetsWithTheme(String theme)
    {
        return getAll().stream()
                .filter(legoSet -> legoSet.getTheme().equals(theme))
                .count();
    }

    /**
     * Prints the LEGO sets that have more pieces in them than specified.
     * @param pieces the number of pieces in a LEGO set
     */
    public void printLegoSetsWithMorePieces(int pieces)
    {
        getAll().stream()
                .filter(legoSet -> legoSet.getPieces() > pieces)
                .map(LegoSet::getName)
                .forEach(System.out::println);
    }

    /**
     * Returns the number of LEGO sets without any tags.
     * @return the number of LEGO sets without any tags
     */
    public long countLegoSetsWithoutTag()
    {
        return getAll().stream()
                .filter(legoSet -> legoSet.getTags() == null)
                .count();
    }

    /**
     * Prints the name of Duplo sets.
     */
    public void printNameOfDuploSets()
    {
        getAll().stream()
                .filter(legoSet -> legoSet.getTheme().equals("Duplo"))
                .map(LegoSet::getName)
                .forEach(System.out::println);
    }

    /**
     * Returns the number of LEGO sets that don't have a subtheme associated with them.
     * @return the number of LEGO sets with no subtheme
     */
    public long countSetsWithoutSubtheme()
    {
        return getAll().stream()
                .filter(legoSet -> legoSet.getSubtheme() == null)
                .count();
    }

    public static void main(String[] args)
    {
        var repository = new LegoSetRepository();

        System.out.println(repository.countLegoSetsWithTheme("Games") + "\n");
        repository.printLegoSetsWithMorePieces(200);
        System.out.println("\n");
        System.out.println(repository.countLegoSetsWithoutTag() + "\n");
        repository.printNameOfDuploSets();
        System.out.println("\n");
        System.out.println(repository.countSetsWithoutSubtheme());
    }
}