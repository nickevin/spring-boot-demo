module.exports = function(grunt) {

  // Project configuration.
  grunt.initConfig({
    pkg: grunt.file.readJSON('package.json'),
    uglify: {
      options: {
        banner: '/*! <%= pkg.name %> <%= grunt.template.today("yyyy-mm-dd") %> */\n'
      },
      build: {
        src: 'src/<%= pkg.name %>.js',
        dest: 'build/<%= pkg.name %>.min.js'
      }
    },
    bower: {
      install: {
        options: {
          targetDir: "./lib",
          layout: "byComponent",
          install: true,
          verbose: false,
          cleanTargetDir: false
        }
      }
    },
    copy: {
      bootstrap: {
        files: [{
          expand: true,
          cwd: './bower_components/bootstrap/dist',
          src: ['**'],
          dest: './lib/bootstrap'
        }]
      }
    }
  });

  require('load-grunt-tasks')(grunt);

  grunt.registerTask('default', ['uglify', 'bower', 'copy']);

};
