// this script contains data of the presentation

// header data
data.head.title = 'reveal.js'
data.head.description = 'An easy to use CSS 3D slideshow tool for quickly creating good looking HTML presentations.'
data.head.author = 'Hakim El Hattab'

// title page
data.cover.title = 'Reveal.js'
data.cover.subtitle = 'CSS 3D Presentations'

// sections
sections.section {
    h2 'Heads Up'
    p """reveal.js is an easy to use, HTML based, presentation tool. You'll need a modern browser with
            support for CSS 3D transforms to see it in its full glory."""
    p {
        i {
            small {
                mkp.yield '-'
                a(href: 'http://hakim.se', 'Hakim El Hattab')
                mkp.yield ' /'
                a(href: 'http://twitter.com/hakimel', '@hakimel')
            }
        }
    }
}

sections.section {
    h2 'What\'s the deal with Groovy?'
    p {
        mkp.yield 'Groovy is an agile and dynamic language for the Java Virtual Machine.'
        a(href: 'http://groovy.codehaus.org/Creating+XML+using+Groovy%27s+MarkupBuilder', "Groovy's MarkupBuilder")
        mkp.yield " supports Groovy's builder pattern with XML/HTML."
    }

    p {
        i {
            small {
                mkp.yield '-'
                a(href: 'http://www.aonnet.de', 'Thomas Westphal')
                mkp.yield ' /'
                a(href: 'http://twitter.com/twest72', '@twest72')
                mkp.yield ' /'
                a(href: 'https://github.com/twest72', 'twest72@github')
            }
        }
    }
}

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

// Example of nested vertical slides
sections.section {
    section {
        h2 'Vertical Slides'
        p {
            mkp.yield 'Slides can be nested inside of other slides,'
            br()
            mkp.yield 'try pressing'
            a(href: '#/2/1', 'down.')
        }
        a(href: '#/2/1', class: 'image') {
            img(src: 'https://s3.amazonaws.com/hakim-static/reveal-js/arrow.png', height: '238', width: '178')
        }
    }
    section {
        h2 'Basement Level 1'

        p 'Press down or up to navigate.'
    }
    section {
        h2 'Basement Level 2'
        p 'Cornify'
        a(href: 'http://cornify.com', class: 'test') {
            img(src: 'https://s3.amazonaws.com/hakim-static/reveal-js/cornify.gif', height: '326', width: '280')
        }
    }
    section {
        h2 'Basement Level 3'
        p '''That's it, time to go back up.'''
        a(href: '#/2', class: 'image') {
            img(src: 'https://s3.amazonaws.com/hakim-static/reveal-js/arrow.png', height: '238', width: '178')
        }
    }
}


sections.section {
    h2 'Holistic Overview'
    p {
        mkp.yield 'Press'
        strong 'ESC'
        mkp.yield ' to enter the slide overview!'
    }
}


sections.section {
    h2 'Works in Mobile Safari'
    p 'Try it out! You can swipe through the slides pinch your way to the overview.'
}


sections.section {
    h2 'Transition Styles'
    p 'You can select from different transitions, like:'
    ul {
        li { a(href: "${ targetUrl }?transition=cube", 'Cube') }
        li { a(href: "${ targetUrl }?transition=page", 'Page') }
        li { a(href: "${ targetUrl }?transition=concave", 'Concave') }
        li { a(href: "${ targetUrl }?transition=linear", 'Linear') }
    }
}


sections.section {
    h2 'Marvelous Unordered List'
    ul {
        li 'No order here'
        li 'Or here'
        li 'Or here'
        li 'Or here'
    }
}


sections.section {
    h2 'Fantastic Ordered List'
    ol {
        li 'One is smaller than...'
        li 'Two is smaller than...'
        li 'Three!'
    }
}


sections.section {
    h2 'Clever Quotes'
    p {
        mkp.yield 'These guys come in two forms, inline:'
        q(cite: 'http://searchservervirtualization.techtarget.com/definition/Our-Favorite-Technology-Quotations', 'The nice thing about standards is that there are so many to choose from')
        br()
        mkp.yield 'and block:'
    }
    blockquote(cite: 'http://searchservervirtualization.techtarget.com/definition/Our-Favorite-Technology-Quotations', 'For years there has been a theory that millions of monkeys typing at random on millions of typewriters would reproduce the entire works of Shakespeare. The Internet has proven this theory to be untrue.')
}


sections.section {
    h2 'Pretty Code'
    pre {
        code(contenteditable: '') {
            mkp.yieldUnescaped new File("$scriptPath/example.js").text
        }
    }
    p {
        mkp.yield 'Courtesy of'
        a(href: 'http://softwaremaniacs.org/soft/highlight/en/description/', 'highlight.js')
    }
}


sections.section {
    h2 'Stellar Links'
    ul {
        li {
            a(href: 'https://github.com/hakimel/reveal.js', 'Source code on github')
        }
        li {
            a(href: 'http://hakim.se/projects/reveal-js', 'Read more on my site')
        }
        li {
            a(href: 'http://twitter.com/hakimel', 'Follow me on Twitter')
        }
    }
}


sections.section {
    h1 'THE END'
    h3(class: 'inverted', 'BY Hakim El Hattab / hakim.se')
}

// returns the presentation data
return data
