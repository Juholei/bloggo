(ns bloggo.main.controllers.posts
  (:require [tuck.core :as tuck :refer-macros [define-event]]
            [bloggo.main.api :as api]))

(define-event SetPosts [posts]
  {:path [:posts]}
  (concat app posts))

(define-event GetPosts [page]
  {}
  (tuck/fx (assoc app :in-progress? true)
           {:tuck.effect/type ::api/get
            :path             (str "/posts/" page)
            :on-success       ->SetPosts}))

