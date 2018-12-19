package utils;

public final class Encryption {

  public static String encryptDecryptXOR(String rawString) {

    // If encryption is enabled in Config.
    if (Config.getEncryption()) {

      // The key is predefined and hidden in code
      // TODO: Create a more complex code and store it somewhere better(FIX)
      char[] key = Config.getKEY().toCharArray();

      // Stringbuilder enables you to play around with strings and make useful stuff
      StringBuilder thisIsEncrypted = new StringBuilder();

      // TODO: This is where the magic of XOR is happening. Are you able to explain what is going on? (FIX)
      /**
       -	For-loppet forsætter med at køre, men stopper når der ikke er flere karakterer i rawString
       -	RawString er den string, som vi ønsker at kryptere
       -    For-loppet kører i første omgang med i=0, derefter bliver den karakter der sat ind på i’s til en binære værdi
       -	Dette samme gøres med karakteren, som er på i’s plads i charArray key.
       -	Derved har vi 2 binære værdier, som lægges sammen ved brug af XOR
       -	Der returnenes en ny binære værdi, som bliver omdannet til char, og derefter bliver tilføjet til metoden thisIsEncrypted
       -    Dette gøres med thisIsEncrypted.append metoden.
       -	Dette sker indtil der ikke er flere karakter i rawString
       -	Hvis man oplever at charArray key er mindre end rawString, bruges modulus til at starte charArray key forfra.
       *
       */
      for (int i = 0; i < rawString.length(); i++) {
        thisIsEncrypted.append((char) (rawString.charAt(i) ^ key[i % key.length]));
      }

      // We return the encrypted string
      return thisIsEncrypted.toString();

    } else {
      // We return without having done anything
      return rawString;
    }
  }
}
