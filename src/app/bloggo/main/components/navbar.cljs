(ns bloggo.main.components.navbar)

(defn navbar [nav-items]
  [:nav>ul
   (for [item nav-items]
     ^{:key (str "nav-item-" (:label item))}
     [:li>a {:href (:url item)} (:label item)])])
