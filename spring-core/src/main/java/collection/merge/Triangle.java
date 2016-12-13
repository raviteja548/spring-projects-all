package collection.merge;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Triangle implements Shape, ApplicationContextAware, BeanNameAware {

	private List<Point> points;

	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}

	public void draw() {
		System.out.println(points.size()+"are objects in list");
		for (Point al : points) {
			System.out.println(al.getX() + " " + al.getY());
		}
	}

	public void setBeanName(String name) {
		System.out.println(name);

	}

	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {

        System.out.println("Last Execution"+arg0.getBean("chi-triangle"));
	}

}
