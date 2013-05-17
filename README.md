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

<form action="https://www.paypal.com/cgi-bin/webscr" method="post" target="_top">
<input type="hidden" name="cmd" value="_s-xclick">
<input type="hidden" name="encrypted" value="-----BEGIN PKCS7-----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-----END PKCS7-----
">
<input type="image" src="https://www.paypalobjects.com/en_US/i/btn/btn_donate_LG.gif" border="0" name="submit" alt="PayPal - The safer, easier way to pay online!">
<img alt="" border="0" src="https://www.paypalobjects.com/pt_BR/i/scr/pixel.gif" width="1" height="1">
</form>
