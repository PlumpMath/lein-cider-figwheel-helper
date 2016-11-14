(defproject lein-cider-figwheel-helper "0.0.1"
  :description "Add a dependencies to develop"
  :url "http://TODO"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :profiles {:dev {:main leiningen.cider-figwheel-helper
                   :dependencies [[org.clojure/clojure "1.8.0"]
                                  [leiningen-core "2.7.1"]]}})
