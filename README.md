# kleines Just-for-Fun-Projekt zum Lernen.

Das Programm ordnet eine Menge an Wörtern anhand ihrer Eigenschaften in einem dreidimensionalen Raum ein. Auf Basis dieser Einordnung können in der Main-Methode Eingaben gemacht werden, zum Beispiel falsch geschriebene Wörter, die dann anhand ihrer eigenen Koordinaten dem am besten passenden bekannten Wort zugeordnet werden sollen. Es handelt sich quasi um eine sehr einfache, fehleranfällige Autokorrektur.

Die Idee zu diesem Projekt entstand aus der Überlegung, wie LLMs Wörter als Punkte in einem Vektorraum abbilden, um Ähnlichkeit über Nähe zu bestimmen.

Aktuell besteht das Vokabular aus einer festen Liste deutscher Städtenamen, die beim Start automatisch in den Raum eingeordnet werden.

## Koordinaten

Jedes Wort wird auf drei Koordinaten abgebildet, die zusammen seine Position im Raum bestimmen:

Die X-Koordinate entspricht der Länge des Wortes, also der Anzahl seiner Buchstaben.

Die Y-Koordinate entspricht der Anzahl unterschiedlicher Buchstaben im Wort, also wie viele verschiedene Zeichen darin vorkommen.

Die Z-Koordinate entspricht der Anzahl unterschiedlicher Vokale (a, e, i, o, u), die im Wort verwendet werden.

Die Implementierung ist in der Klasse Room.java in der Methode getCoords() zu finden.

Bei der Suche wird für ein eingegebenes Wort zunächst ebenfalls diese Koordinate berechnet. Anschließend werden alle Wörter in den umliegenden Zellen des Raums als Kandidaten betrachtet, und aus diesen Kandidaten wird dasjenige mit der geringsten Levenshtein-Distanz zum eingegebenen Wort als Ergebnis zurückgegeben
