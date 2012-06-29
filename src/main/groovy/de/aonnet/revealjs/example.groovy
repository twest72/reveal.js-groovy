sections.section {
    h2 'Pretty Groovy Code for reveal.js'
    p "The following script contains the code for this page. 'example.groovy' is a Groovy script."
    pre {
        code(class:'java', contenteditable: '') {
            mkp.yieldUnescaped new File("$scriptPath/example.groovy").text
        }
    }
    p {
        mkp.yield 'Courtesy of'
        a(href: 'http://softwaremaniacs.org/soft/highlight/en/description/', 'highlight.js')
    }
}

