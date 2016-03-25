module.exports = function(grunt) {

  grunt.initConfig({
    pkg : grunt.file.readJSON('package.json'),
    bower : {
      install : {
        options : {
          targetDir : "./lib",
          layout : "byComponent",
          install : true,
          verbose : false,
          cleanTargetDir : false
        }
      }
    },
    copy : {
      bootstrap : {
        files : [ {
          expand : true,
          cwd : './bower_components/bootstrap/dist',
          src : [ '**' ],
          dest : './lib/bootstrap'
        } ]
      }
    },
    uglify : {
      options : {},
      dist : {
        files : {
          './lib/jquery/jquery.js' : [ './lib/jquery/jquery.js' ]
        }
      }
    },
    cssmin : {
      compress : {
        expand : true,
        cwd : './style',
        src : [ '*.css', '!*.min.css' ],
        dest : './style',
        ext : '.min.css'
      },
      combine : {
        files : {
          './style/style.css' : [ './style/style-1.min.css',
              './style/style-2.min.css' ]
        }
      }
    }
  });

  require('load-grunt-tasks')(grunt);

  grunt.registerTask('default', [ 'bower', 'copy', 'uglify', 'cssmin' ]);
};
