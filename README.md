SDCardFilePaths
===============

Features:
* Get all available SDCard file paths in your device
* Get External SDCard File path (Removable Storage) in your device

![SDCardFilePaths](https://raw.githubusercontent.com/hiepxuan2008/SDCardFilePaths/master/Screenshot.jpg)

Usage
-----
```
File sdcards[] = getAllAvailableSDCards(getApplicationContext());
File externalSdCard = getExternalSDCard(getApplicationContext());
```

Limitation
-----
It is only available in Android 4.4 KitKat(API level 19) and above.