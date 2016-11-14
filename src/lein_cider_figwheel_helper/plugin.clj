(ns lein-cider-figwheel-helper.plugin
  (:require [leiningen.core.project :refer [merge-profiles]]))

(defn middleware
  [project]
  (let [deps (->> project
                  :dependencies
                  (map first)
                  (into #{}))
        plugins (->> project
                     :plugins
                     (map first)
                     (into #{}))]
    (cond-> project
      (and (contains? deps 'org.clojure/clojurescript)
           (not (contains? plugins 'lein-figwheel))
           (not (contains? deps 'figwheel-sidecar)))
      (-> (update :dependencies concat [['com.cemerick/piggieback "0.2.1"]
                                        ['figwheel-sidecar "0.5.8"]])
          (update-in [:repl-options :nrepl-middleware]
                     concat ['cemerick.piggieback/wrap-cljs-repl])))))
