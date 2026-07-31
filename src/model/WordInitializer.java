package model;

public class WordInitializer {

    private Room room;

    public WordInitializer(Room room){
        this.room = room;
    }

    public void initializeWords(){
        String[] cities = {
                "Berlin", "München", "Köln", "Frankfurt", "Hamburg",
                "Düsseldorf", "Dortmund", "Essen", "Leipzig", "Dresden",
                "Hannover", "Nürnberg", "Duisburg", "Bochum", "Wuppertal",
                "Bielefeld", "Bonn", "Münster", "Karlsruhe", "Mannheim",
                "Stuttgart", "Augsburg", "Gelsenkirchen", "Braunschweig", "Chemnitz",
                "Kiel", "Aachen", "Rostock", "Oberhausen", "Saarbrücken",
                "Mainz", "Wiesbaden", "Magdeburg", "Mönchengladbach", "Krefeld",
                "Oldenburg", "Potsdam", "Osnabrück", "Solingen", "Halle",
                "Freiburg", "Erfurt", "Trier", "Recklinghausen", "Göttingen",
                "Castrop-Rauxel", "Ludwigshafen", "Paderborn", "Koblenz", "Kreis",
                "Salzgitter", "Villingen", "Konstanz", "Heilbronn", "Pforzheim",
                "Würzburg", "Bamberg", "Bayreuth", "Regensburg", "Passau",
                "Ingolstadt", "Landshut", "Straubing", "Füssen", "Memmingen",
                "Kaufbeuren", "Kempten", "Ulm", "Metzingen", "Reutlingen",
                "Tübingen", "Ludwigsburg", "Esslingen", "Göppingen", "Waiblingen",
                "Böblingen", "Sindelfingen", "Offenburg", "Lahr", "Villingen-Schwenningen",
                "Singen", "Radolfzell", "Überlingen", "Friedrichshafen", "Lindau",
                "Konstanz", "Tuttlingen", "Rottweil", "Schramberg", "Furtwangen",
                "Schwäbisch Gmünd", "Aalen", "Ellwangen", "Crailsheim", "Öhringen",
                "Bad Mergentheim", "Tauberbischofsheim", "Wertheim", "Mosbach", "Buchen"
        };

        for (String city : cities) {
            room.putIn(city);
        }
    }
}