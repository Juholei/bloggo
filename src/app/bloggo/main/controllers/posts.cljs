(ns bloggo.main.controllers.posts
  (:require [tuck.core :as tuck :refer-macros [define-event]]
            [bloggo.main.api :as api]
            [camel-snake-kebab.core :as cskc]
            [camel-snake-kebab.extras :as cske]))

(defn json->map [json]
  (cske/transform-keys cskc/->kebab-case-keyword json))

(define-event SetPosts [posts]
  {:path [:posts]}
  (->> posts
       (map json->map)
       (concat app)))

(define-event GetPosts [page]
  {}
  (tuck/fx (assoc app :in-progress? true)
           {:tuck.effect/type ::api/get
            :path             (str "/posts/" page)
            :on-success       ->SetPosts}))

