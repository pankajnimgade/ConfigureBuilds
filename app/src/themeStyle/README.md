Theme and Styles

They're technically the same thing
Themes == Styles

both declared using <style> tag

The only difference between them is how they're used

#Style

A style is a collection of properties that specify the look and format for a View or Window.

#Theme

A Theme is a style applied to an entire Activity of Application, rather than an individual View.

Theme.MaterialComponents
Theme.MaterialComponents.NoActionBar
Theme.MaterialComponents.Light
Theme.MaterialComponents.Light.NoActionBar
Theme.MaterialComponents.Light.DarkActionBar

#Colors             Swatch number
-----------------------------------
colorPrimary        500
-----------------------------------
colorPrimaryDark    700
-----------------------------------
colorAccent         200   ---(secondary Color)
-----------------------------------

#Theme.AppCompat.DayNight
-----------------------------------------------------------
AppCompatDelegate.MODE_NIGHT_NO : the day (light) theme.
-----------------------------------------------------------
AppCompatDelegate.MODE_NIGHT_YES : the night (dark) theme.
-----------------------------------------------------------
AppCompatDelegate.MODE_NIGHT_AUTO : day/night mode change according to time.
-----------------------------------------------------------
AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM (default). this mode uses system night modes settings to determine if it is night or not.
-----------------------------------------------------------
