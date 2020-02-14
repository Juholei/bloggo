(ns bloggo.main.components.navbar)

(defn navlink [url text]
  [:li.mr-6
   [:a {:class ["text-blue-500" "hover:text-blue-800"]
        :href url}
    text]])

(defn navbar [nav-items]
  [:nav>ul.flex
   (for [item nav-items]
     ^{:key (str "nav-item-" (:label item))}
     [navlink (:url item) (:label item)])])
