Spek (Working Title)
----------

###Proposal
The plan is to make a hardware listing app for Android that aims to marry the clarity of "About Phone" section with the extensive information of Unix utilities like [lshw](http://www.ezix.org/project/wiki/HardwareLiSter) and [lspci](http://mj.ucw.cz/sw/pciutils/).

###Why
The `About Phone` section in Android Settings can give you some very basic information about an Android device. Which model it is, which version of Android it's running, and so on. It however doesn't tell you very much about the actual hardware inside. What CPU does it have? Which OpenGL version does it support? For Android devices especially the hardware will widly vary from manufacturor to manufacturor and model to model.

Granted, these things might not matter much to average users but what if you like to game a lot? Or what if it turns out [your manufacturor has put inferoir chipsets in some devices of the same model](https://youtu.be/m1fUil7QLNI)?   

Looking at [some](https://play.google.com/store/apps/details?id=com.inkwired.droidinfo) [existing](https://play.google.com/store/apps/details?id=com.dama.hardwareinfo) [hardware listing](https://play.google.com/store/apps/details?id=com.sysinfodroid) [apps](https://f-droid.org/repository/browse/?fdfilter=Hardware&fdid=jackpal.droidexaminer) there seem to be two main issues to try and avoid.  
* The look of these apps seems to range from barest of bones to way overdoing it.
* All of these apps are intent on showing you ALL of the info, including every single configuration flag available.

For our app then, we will focus on a clarifying simple design and (by default) limiting the information shown to a manageable list of actually relevant information.

###Implementation
The big question in making a hardware listing is where to get your infromation from.

Utitlities like lshw and lspci make use of the special Unix [`/proc`](http://www.tldp.org/LDP/Linux-Filesystem-Hierarchy/html/proc.html) filesystemto gather al their info.  

Android devices, which run off the Linux kernel, also have a `/proc` of their own, so this is definitely an option, but thankfully for us, a lot of the information in there is already easily available from within a regular Activity, like the [Build](which will make our job considerably easier.   
If it turns out we can't find everything from inside the Application environment, `/proc` will always be there for us, but for now we'll try to fetch as much information possible from within the application itself.

###Features

For our app we'll be looking for the following features:
+ TargetSdk 6.1
  + [Nice to Have] minSdk 4.4
+ Clean, nice-looking design.
  + Using Material Design
  + Using About phone as a possible example
  + More than just printing /proc content to screen as-is
  + [Nice to Have] Navigation bar for various sections
+ Relevant Information Only.
  + [Must Have] CPU
    + [MAYBE] CPU Codenames? (i.e. `Snapdragon 810` in stead of `Qualcomm Technologies MSM8994`)
  + [Must Have] GPU
  + [Must Have] Android version, kernel version, build number, (boot loader?)
  + [Must Have] Sound (Soundcard, Speakers etc.)
  + [Must Have] Camera
    + [Android 6.0+] Ask for Camera Permissions.
  + [Nice to Have] Sensors
  + [Nice to Have] Setting checkboxes on what (not) to show
  + ...
+ Write specs to File.
  + [Nice to have] flags on what (not) write to file.
+ Copy specific field (like CPU name) to clipboard.

###Possible Issues
+ Hard to test in emulators
+ CPU Codenames would have to be manually stored somewhere (and updated)
+ Doesn't really use any fancy APIs (unless you count `/proc`)
