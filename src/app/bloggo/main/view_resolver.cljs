(ns bloggo.main.view-resolver
  (:require [bloggo.main.views.main-page :as main-page]
            [bloggo.main.routes :as routes]
            [bloggo.main.views.post-page :as post-page]))

(defmulti root-view :view)
(defmethod root-view :default [params]
  (println "default view resolver called" params)
  nil)

(defmethod root-view ::routes/frontpage [app-state e!]
  [main-page/main-page (:posts app-state)])

(defmethod root-view ::routes/post [{:keys [current-post]} e!]
  [post-page/post-page current-post])
