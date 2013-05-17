#Fred

**F**riendly **Re**sizer **D**roid

![Fred logo](https://dl.dropboxusercontent.com/u/5135185/blog/fred.png)

A tool to resize images to the various screen densities of Android devices.

##Current version
1.0 (20130502). Download the binary here: [fred-1.0.jar](https://dl.dropboxusercontent.com/u/5135185/blog/fred-1.0.jar).

##Purpose
When developing/designing for Android, you have to deal with a bunch of different screen sizes and resolutions. If you design your layouts following the design guidelines and develop them using properly the SDK, you'll have no trouble. Android do all the hard work for you.

But if you don't supply different versions of your image resources for the different screen sizes, Android will do that at runtime. And, this way, your app will be slow. Thus, is always a good idea to supply images on the *drawable-xhdpi*, *drawable-hdpi*, *drawable-mdpi* and (maybe) *drawable-ldpi* folders.

But do this in an image editor (like Photoshop) takes time. And it's extremely boring. So why lose time doing that? Fred can do this job for you! And trust me, he would be very happy to help.

##How it works
While designing your layouts, use the [Nexus 4](https://www.google.com/nexus/4/) and its resolution (1280x768) as the base. After that, slice and export all your image resources.

Then, launch Fred and drag and drop the folder with the images on it. Fred will resize all and create the *drawable-xhdpi*, *drawable-hdpi*, *drawable-mdpi* and (maybe) *drawable-ldpi* folders for you. After that, just move them to your Android project.

##Usage
Download [the executable jar](https://dl.dropboxusercontent.com/u/5135185/blog/fred-1.0.jar) and double-click it. Fred's window will appear. Drag a folder from your file explorer and drop on it.

You need to have [Java](https://www.java.com/en/download/index.jsp) installed to run Fred.

##License
Fred's source code is released under BSD 2-clause license. Check LICENSE file for more information.

If you use this code, I'd appreciate you refer my name (Leocadio Tiné) and the link to this project's page in your project's website or credits screen. Though you don't have any legal/contractual obligation to do so, just good karma.

##Suggestions? Comments?
Pull requests are always welcome. So are donations :)

To find me, buzz at `me[at]leocad.io` or [follow me on Twitter](http://www.twitter.com/leocadiotine). To read interesting stuff, go to [my blog](http://blog.leocad.io).

Special thanks to [swannodette](https://github.com/swannodette) and [zachallaun](https://github.com/zachallaun) for the pull requests!

~~~~
:::::::::::::
::         ::
:: Made at ::
::         ::
:::::::::::::
     ::
Hacker School
:::::::::::::
~~~~

[![Donate button](https://www.paypalobjects.com/en_US/i/btn/btn_donate_LG.gif)](https://www.paypal.com/cgi-bin/webscr?cmd=_donations&business=PPHGB75L9LUC4&lc=US&item_name=Leocadio%20Tin%c3%a9&currency_code=USD&bn=PP%2dDonationsBF%3abtn_donate_LG%2egif%3aNonHosted)