// this script contains the (most) static code of the presentation

// fallback for properties
try {
    println "scriptPath: $scriptPath"

} catch (MissingPropertyException e) {
    setProperty('scriptPath', '.')
    println "scriptPath: $scriptPath"
}
try {
    println "targetDir: $targetDir"

} catch (MissingPropertyException e) {
    setProperty('targetDir', '.')
    println "targetDir: $targetDir"
}
try {
    println "targetName: $targetName"

} catch (MissingPropertyException e) {
    setProperty('targetName', 'index.html')
    println "targetName: $targetName"
}
try {
    println "targetUrl: $targetUrl"

} catch (MissingPropertyException e) {
    setProperty('targetUrl', '.')
    println "targetUrl: $targetUrl"
}

// Map and builder initialisation (for presentation data)
def data = [:]
data.head = [:]
data.cover = [:]
data.sectionWriter = new StringWriter()
def sections = new groovy.xml.MarkupBuilder(data.sectionWriter)

// call the script with the presentation data
def scriptEngine = new GroovyScriptEngine([scriptPath] as String[])

def binding = new Binding()
binding.setVariable 'data', data
binding.setVariable 'sections', sections
binding.setVariable 'scriptPath', scriptPath
binding.setVariable 'targetName', targetName
binding.setVariable 'targetUrl', targetUrl

data = scriptEngine.run 'index-data.groovy', binding

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
        div(class: 'reveal') {

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

            // The navigational controls UI
            aside(class: "controls") {
                a(class: "left", href: "#") {
                    mkp.yieldUnescaped '&#x25C4;'
                }
                a(class: "right", href: "#") {
                    mkp.yieldUnescaped '&#x25BA;'
                }
                a(class: "up", href: "#") {
                    mkp.yieldUnescaped '&#x25B2;'
                }
                a(class: "down", href: "#") {
                    mkp.yieldUnescaped '&#x25BC;'
                }
            }

            // Displays presentation progress, max value changes via JS to reflect # of slides
            div(class: "progress") {
                span()
            }
        }

        // Optional libraries for code syntax highlighting and classList support in IE9

        // Attention: the empty content is necessary to generate:
        // <script src='lib/highlight.js'></script>
        // instead: <script src='lib/highlight.js' />
        script(src: 'lib/highlight.js', '')
        script(src: 'lib/classList.js', '')

        // libraries for reveal.js
        script(src: 'js/reveal.js', '')
        script {
            mkp.yieldUnescaped new File("$scriptPath/reveal-initialize.js").text
        }
    }
}
