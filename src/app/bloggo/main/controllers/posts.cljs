(ns bloggo.main.controllers.posts
  (:require [tuck.core :as tuck :refer-macros [define-event]]
            [bloggo.main.api :as api]))

(defn add-posts
  "Adds new posts to the end of existing and removes duplicates"
  [existing new]
  (->> new
       (concat existing)
       distinct))

(define-event AddPosts [posts]
  {:path [:posts]}
  (add-posts app posts))

(define-event GetPosts [page]
  {}
  (tuck/fx (assoc app :in-progress? true)
           {:tuck.effect/type ::api/get
            :path             (str "/posts/" page)
            :on-success       ->AddPosts}))

(define-event ShowPost [post]
  {}
  (assoc app :in-progress? false :current-post post))

(define-event GetPost [id on-success]
  {}
  (tuck/fx (assoc app :in-progress? true)
           {:tuck.effect/type ::api/get
            :path (str "/post/" id)
            :on-success on-success}))

