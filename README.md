# Flickr App
Simple app to get recent and explore images from Flickr API. Also you can search images by text. It shows search history which you can remove easily.

You can use my API key. If you want to change it with yours, you can simply change API_KEY in app level gradle.

The reason of using toolbar in Recent Images UI is to get closest UI asked in PDF

## Installation

You can [click here](https://play.google.com/store/apps/details?id=com.kangarootech.flickr) to download the app easily. (Google Play)
You can also [click here](https://drive.google.com/open?id=1QGv40F0CGYPDMiCTmBV_QC1CUF_1sM1g) to download apk file. (Google Drive)


## Third-Party Libraries
* [Retrofit](https://square.github.io/retrofit/)

* [Gson Converter](https://github.com/square/retrofit/tree/master/retrofit-converters/gson) 
Flickr API provides images as URL not String. Gson is faster than Jackson when it is about short length strings. 

* [Circular Image View](https://github.com/hdodenhof/CircleImageView) 
Easy to use. High star count (11.750) and low issue count (8). Also it has Apache 2.0 licence.

* [Picasso](https://square.github.io/picasso/) 
Picasso loads images (from network, not cache) faster than Glide. It is also lighter than Glide. Picasso provides all the needs. Also with the last update, Picasso doesn't need context as parameter. That's why I've chosen Picasso. 

## About Custom Views
* ZoomImageView
I've used [Dhaval Solanki's answer](https://stackoverflow.com/questions/48644143/on-touch-of-image-image-view-to-fullscreen-and-zoom-should-work). I've just converted it to Kotlin by hand and changed it's name. 

## Licence
[APACHE 2.0](https://choosealicense.com/licenses/apache-2.0/)
