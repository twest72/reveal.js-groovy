// Map and Builder initialisation
def data = [:]
data.head = [:]
data.cover = [:]
data.sectionWriter = new StringWriter()
data.sections = new groovy.xml.MarkupBuilder(data.sectionWriter)




// target url
data.url = 'http://lab.hakim.se/reveal-js'


// header data
data.head.title = 'reveal.js'
data.head.description = 'An easy to use CSS 3D slideshow tool for quickly creating good looking HTML presentations.'
data.head.author = 'Hakim El Hattab'


// title page
data.cover.title = 'Reveal.js'
data.cover.subtitle = 'CSS 3D Presentations'


// sections
data.sections.section {
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


// Example of nested vertical slides
data.sections.section {
    section {
        h2 'Vertical Slides'
        p {
            mkp.yield 'Slides can be nested inside of other slides,'
            br()
            mkp.yield 'try pressing'
            a(href:'#/2/1', 'down.')
        }
        a(href: '#/2/1', class:'image') {
            img(src:'https://s3.amazonaws.com/hakim-static/reveal-js/arrow.png', height:'238', width:'178')
        }
    }
    section {
        h2 'Basement Level 1'

        p 'Press down or up to navigate.'
    }
    section {
        h2 'Basement Level 2'
        p 'Cornify'
        a(href: 'http://cornify.com', class:'test') {
            img(src:'https://s3.amazonaws.com/hakim-static/reveal-js/cornify.gif', height:'326', width:'280')
        }
    }
    section {
        h2 'Basement Level 3'
        p '''That's it, time to go back up.'''
        a(href: '#/2', class:'image') {
            img(src:'https://s3.amazonaws.com/hakim-static/reveal-js/arrow.png', height:'238', width:'178')
        }
    }
}


data.sections.section {
    h2 'Holistic Overview'
    p 'Press'
    strong 'ESC'
    p 'to enter the slide overview!'
}


data.sections.section {
    h2 'Works in Mobile Safari'
    p 'Try it out! You can swipe through the slides pinch your way to the overview.'
}


data.sections.section {
    h2 'Transition Styles'
    p 'You can select from different transitions, like:'
    ul {
        li { a(href: "${ data.url }/?transition=cube", 'Cube') }
        li { a(href: "${ data.url }/?transition=page", 'Page') }
        li { a(href: "${ data.url }/?transition=concave", 'Concave') }
        li { a(href: "${ data.url }/?transition=linear", 'Linear') }
    }
}


data.sections.section {
    h2 'Marvelous Unordered List'
    ul {
        li 'No order here'
        li 'Or here'
        li 'Or here'
        li 'Or here'
    }
}


data.sections.section {
    h2 'Fantastic Ordered List'
    ol {
        li 'One is smaller than...'
        li 'Two is smaller than...'
        li 'Three!'
    }
}


data.sections.section {
    h2 'Clever Quotes'
    p {
        mkp.yield 'These guys come in two forms, inline:'
        q(cite:'http://searchservervirtualization.techtarget.com/definition/Our-Favorite-Technology-Quotations', 'The nice thing about standards is that there are so many to choose from')
        br()
        mkp.yield 'and block:'
    }
    blockquote(cite:'http://searchservervirtualization.techtarget.com/definition/Our-Favorite-Technology-Quotations', 'For years there has been a theory that millions of monkeys typing at random on millions of typewriters would reproduce the entire works of Shakespeare. The Internet has proven this theory to be untrue.')
}


data.sections.section {
    h2 'Pretty Code'
    pre {
        code(contenteditable:'') {
           mkp.yieldUnescaped """
var supports3DTransforms =  document.body.style['webkitPerspective'] !== undefined ||
        document.body.style['MozPerspective'] !== undefined ||
        document.body.style['perspective'] !== undefined;

function linkify( selector ) {
   if( supports3DTransforms ) {

       var nodes = document.querySelectorAll( selector );

       for( var i = 0, len = nodes.length; i < len; i++ ) {
           var node = nodes[i];

           if( !node.className || !node.className.match( /roll/g ) ) {
               node.className += ' roll';
               node.innerHTML = '<span data-title="'+ node.text +'">' + node.innerHTML + '</span>';
           }
       };
   }
}

linkify( 'a' );
"""
        }
    }
    p {
        mkp.yield 'Courtesy of'
        a(href:'http://softwaremaniacs.org/soft/highlight/en/description/', 'highlight.js')
    }
}


data.sections.section {
    h2 'Stellar Links'
    ul {
        li {
            a(href:'https://github.com/hakimel/reveal.js', 'Source code on github')
        }
        li {
            a(href:'http://hakim.se/projects/reveal-js', 'Read more on my site')
        }
        li {
            a(href:'http://twitter.com/hakimel', 'Follow me on Twitter')
        }
    }
}


data.sections.section {
    h1 'THE END'
    h3(class:'inverted', 'BY Hakim El Hattab / hakim.se')
}

return data
