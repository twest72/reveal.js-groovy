// fallback for properties
if(!hasProperty('scriptPath')) setProperty('scriptPath', '.')
if(!hasProperty('targetDir')) setProperty('targetDir', '.')
if(!hasProperty('targetName')) setProperty('targetName', 'index.html')


// data of the presentation
def data = evaluate(new File("$scriptPath/index-data.groovy"))


// builder initialisation
def fileName = "$targetDir/$targetName"
def fileWriter = new FileWriter(fileName)
def builder = new groovy.xml.MarkupBuilder(fileWriter)


// presentation build
builder.html(lang: 'en') {
    head {
        meta(charset: 'UTF-8')

        title data.head.title

        meta(name: 'description', content: data.head.description)
        meta(name: 'author', content: data.head.author)

        meta(name: 'apple-mobile-web-app-capable', content: 'yes')
        meta(name: 'apple-mobile-web-app-status-bar-style', content: 'black-translucent')

        link(href: 'http://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic', rel: 'stylesheet', type: 'text/css')


        link(rel: 'stylesheet', href: 'css/reset.css')
        link(rel: 'stylesheet', href: 'css/main.css')
        link(rel: 'stylesheet', href: 'css/print.css', type: 'text/css', media: 'print')

        link(rel: 'stylesheet', href: 'lib/zenburn.css')

    }

    body {
        div(class: 'reveal linear') {

            // Used to fade in a background when a specific slide state is reached
            div(class: 'state-background')

            // Any section element inside of this container is displayed as a slide
            div(class: 'slides') {


                section(class: 'present', style: 'display: block;') {
                    h1 data.cover.title
                    h3(class: 'inverted', data.cover.subtitle)
                    // Delicously hacky. Look away.
                    script """if( navigator.userAgent.match( /(iPhone|iPad|iPod|Android)/i ) ) document.write( '<p style="color: rgba(0,0,0,0.3); text-shadow: none;">('+'Tap to navigate'+')</p>' );"""
                }

                mkp.yieldUnescaped data.sectionWriter
            }
        }



        // The navigational controls UI
        mkp.yieldUnescaped """
        <!-- The navigational controls UI -->
        <aside class="controls">
            <a class="left" href="#">&#x25C4;</a>
            <a class="right" href="#">&#x25BA;</a>
            <a class="up" href="#">&#x25B2;</a>
            <a class="down" href="#">&#x25BC;</a>
        </aside>

        <!-- Displays presentation progress, max value changes via JS to reflect # of slides -->
        <div class="progress"><span></span></div>
        """

        // Optional libraries for code syntax highlighting and classList support in IE9
        mkp.yieldUnescaped """
        <!-- Optional libraries for code syntax highlighting and classList support in IE9 -->
        <script src="lib/highlight.js"></script>
        <script src="lib/classList.js"></script>

        <script src="js/reveal.js"></script>

        <script>
            // Parse the query string into a key/value object
            var query = {};
            location.search.replace( /[A-Z0-9]+?=(\\w*)/gi, function(a) {
                query[ a.split( '=' ).shift() ] = a.split( '=' ).pop();
            } );

            // Fires when a slide with data-state=customevent is activated
            Reveal.addEventListener( 'customevent', function() {
                alert( '"customevent" has fired' );
            } );

            // Fires each time a new slide is activated
            Reveal.addEventListener( 'slidechanged', function( event ) {
                // event.previousSlide, event.currentSlide, event.indexh, event.indexv
            } );

            Reveal.initialize({
                // Display controls in the bottom right corner
                controls: true,

                // Display a presentation progress bar
                progress: true,

                // If true; each slide will be pushed to the browser history
                history: true,

                // Loops the presentation, defaults to false
                loop: false,

                // Flags if mouse wheel navigation should be enabled
                mouseWheel: true,

                // Apply a 3D roll to links on hover
                rollingLinks: true,

                // UI style
                theme: query.theme || 'neon', // default/neon

                // Transition style
                transition: query.transition || 'default' // default/cube/page/concave/linear(2d)
            });

            hljs.initHighlightingOnLoad();
        </script>
"""

    }
}
